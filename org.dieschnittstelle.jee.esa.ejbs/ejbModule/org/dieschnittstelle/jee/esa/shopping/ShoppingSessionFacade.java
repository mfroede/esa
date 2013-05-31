package org.dieschnittstelle.jee.esa.shopping;

import javax.ejb.Remote;

import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.Customer;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;

@Remote
public interface ShoppingSessionFacade {

   public abstract void setTouchpoint(AbstractTouchpoint touchpoint);

   public abstract void setCustomer(Customer customer);

   public abstract void addProduct(AbstractProduct product, int units);

   public abstract void verifyCampaigns();

   public abstract void purchase();

}