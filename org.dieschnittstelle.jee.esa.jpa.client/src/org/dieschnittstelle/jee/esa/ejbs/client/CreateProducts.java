package org.dieschnittstelle.jee.esa.ejbs.client;

import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.TOUCHPOINT_1;

import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.ejbs.crud.TouchpointCRUDRemote;
import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.AbstractProductCRUDRemote;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.PointOfSaleCRUDRemote;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.dieschnittstelle.jee.esa.erp.entities.ProductType;

public class CreateProducts {

   protected static Logger logger = Logger.getLogger(CreateProducts.class);

   public static void main(String[] args) {

      try {
         Context context = new InitialContext();
         AbstractProductCRUDRemote abstractProductCRUDRemote = (AbstractProductCRUDRemote) context.lookup(Constants.ABSTRACT_PRODUCT_CRUD_BEAN);
         logger.debug("got abstractProductCRUDRemote: " + abstractProductCRUDRemote);

         // we first create the erp pos and then a corresponding touchpoint
         IndividualisedProductItem item = new IndividualisedProductItem("TEST", ProductType.BREAD, 1);
         item.setId(1);
         abstractProductCRUDRemote.createAbstractProduct(item);

         Collection<AbstractProduct> printProducts = printProducts(abstractProductCRUDRemote);

         AbstractProduct readAbstractProduct = abstractProductCRUDRemote.readAbstractProduct(item.getId());
         readAbstractProduct.setName("TEST updated");
         abstractProductCRUDRemote.updateAbstractProduct(readAbstractProduct);

         printProducts(abstractProductCRUDRemote);

         abstractProductCRUDRemote.deleteAbstractProduct(readAbstractProduct.getId());

         printProducts(abstractProductCRUDRemote);

      } catch (Exception e) {
         logger.error(e.getMessage(), e);
      }

   }

   private static Collection<AbstractProduct> printProducts(AbstractProductCRUDRemote abstractProductCRUDRemote) {
      Collection<AbstractProduct> readAllAbstractProducts;
      readAllAbstractProducts = abstractProductCRUDRemote.readAllAbstractProducts();
      for (AbstractProduct abstractProduct : readAllAbstractProducts) {
         logger.debug(abstractProduct);
      }
      return readAllAbstractProducts;
   }

}
