package org.dieschnittstelle.jee.esa.shopping;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote;
import org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingRemote;
import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.CrmProductBundle;
import org.dieschnittstelle.jee.esa.crm.model.Customer;
import org.dieschnittstelle.jee.esa.crm.model.CustomerTransaction;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.Campaign;

@Stateful
public class ShoppingSessionFacadeImpl implements ShoppingSessionFacade {
   protected static Logger logger = Logger.getLogger(ShoppingSessionFacadeImpl.class.getName());
   @EJB(beanName="shoppingCart")
   private ShoppingCartRemote shoppingCart;

   @EJB(beanName="customerTracking")
   private CustomerTrackingRemote customerTracking;

   @EJB(beanName="campaignTracking")
   private CampaignTrackingRemote campaignTracking;

   private AbstractTouchpoint touchpoint;
   private Customer customer;
   
   @Override
   public void setTouchpoint(AbstractTouchpoint touchpoint) {
      this.touchpoint = touchpoint;
   }

   @Override
   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   @Override
   public void addProduct(AbstractProduct product, int units) {
      this.shoppingCart.addProductBundle(new CrmProductBundle(product.getId(),
            units,product instanceof Campaign));      
   }

   @Override
   public void verifyCampaigns() {
      if (this.customer == null || this.touchpoint == null) {
         throw new RuntimeException(
               "cannot verify campaigns! No touchpoint has been set!");
      }

      for (CrmProductBundle productBundle : this.shoppingCart
            .getProductBundles()) {
         if (productBundle.isCampaign()) {
            // we check whether we have sufficient campaign items available
            if (this.campaignTracking
                  .existsValidCampaignExecutionAtTouchpoint(
                        productBundle.getErpProductId(),
                        this.touchpoint) < productBundle.getUnits()) {
               throw new RuntimeException(
                     "verifyCampaigns() failed for productBundle "
                           + productBundle + " at touchpoint "
                           + this.touchpoint + "!");
            }
         }
      }      
   }

   @Override
   public void purchase() {
      logger.info("commit()");

      if (this.customer == null || this.touchpoint == null) {
         throw new RuntimeException(
               "cannot commit shopping session! Either customer or touchpoint has not been set: "
                     + this.customer + "/" + this.touchpoint);
      }

      // verify the campaigns
      verifyCampaigns();

      // read out the products from the cart
      List<CrmProductBundle> products = this.shoppingCart.getProductBundles();

      // iterate over the products and purchase the campaigns
      for (CrmProductBundle productBundle : this.shoppingCart
            .getProductBundles()) {
         if (productBundle.isCampaign()) {
            this.campaignTracking.purchaseCampaignAtTouchpoint(
                  productBundle.getErpProductId(), this.touchpoint,
                  productBundle.getUnits());
         }
      }

      // then we add a new customer transaction for the current purchase
      CustomerTransaction transaction = new CustomerTransaction(
            this.customer, this.touchpoint, products);
      transaction.setCompleted(true);
      customerTracking.createTransaction(transaction);

      logger.info("commit(): done.");      
   }

}
