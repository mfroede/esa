package org.dieschnittstelle.jee.esa.ejbs.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.Customer;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.shopping.ShoppingSessionFacade;

public class ShoppingDelegate {

	protected static Logger logger = Logger.getLogger(ShoppingDelegate.class);
	private ShoppingSessionFacade shoppingSessionFacade;

	public ShoppingDelegate() {
		logger.info("<constructor>");
	}

	public void initialise() {
		try {
			// obtain the beans using a jndi context
			Context context = new InitialContext();
			this.shoppingSessionFacade = (ShoppingSessionFacade) context
					.lookup(Constants.SHOPPING_SESSION_BEAN);
			logger.info("got shopping session facade: " + shoppingSessionFacade);

		} catch (Exception e) {
			throw new RuntimeException("initialise() failed: " + e, e);
		}
	}

	/* (non-Javadoc)
    * @see org.dieschnittstelle.jee.esa.ejbs.client.ShoppingCardFacade#setTouchpoint(org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint)
    */
   public void setTouchpoint(AbstractTouchpoint touchpoint) {
		shoppingSessionFacade.setTouchpoint(touchpoint);
	}

	/* (non-Javadoc)
    * @see org.dieschnittstelle.jee.esa.ejbs.client.ShoppingCardFacade#setCustomer(org.dieschnittstelle.jee.esa.crm.model.Customer)
    */
   public void setCustomer(Customer customer) {
		shoppingSessionFacade.setCustomer(customer);
	}

	/* (non-Javadoc)
    * @see org.dieschnittstelle.jee.esa.ejbs.client.ShoppingCardFacade#addProduct(org.dieschnittstelle.jee.esa.erp.model.AbstractProduct, int)
    */
   public void addProduct(AbstractProduct product, int units) {
		shoppingSessionFacade.addProduct(product, units);
	}

	/*
	 * verify whether campaigns are still valid
	 */
	/* (non-Javadoc)
    * @see org.dieschnittstelle.jee.esa.ejbs.client.ShoppingCardFacade#verifyCampaigns()
    */
   public void verifyCampaigns() {
      shoppingSessionFacade.verifyCampaigns();
	}

	/* (non-Javadoc)
    * @see org.dieschnittstelle.jee.esa.ejbs.client.ShoppingCardFacade#purchase()
    */
   public void purchase() {
      shoppingSessionFacade.purchase();
	}

}
