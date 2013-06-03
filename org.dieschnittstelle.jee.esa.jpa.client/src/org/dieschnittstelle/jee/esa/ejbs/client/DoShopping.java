package org.dieschnittstelle.jee.esa.ejbs.client;

import org.apache.log4j.Logger;

public class DoShopping {

	protected static Logger logger = Logger.getLogger(DoShopping.class);
	
	public static void main(String[] args) {
		
		try {
			// create a shopping session and initialise it such that it can access the required beans
			ShoppingSession session = new ShoppingSession();
			session.initialise();
			
			// add a customer and a touchpoint
			session.setCustomer(Constants.CUSTOMER_1);
			session.setTouchpoint(Constants.TOUCHPOINT_1);			
			
			// now add items
			session.addProduct(Constants.PRODUCT_1, 2);
			session.addProduct(Constants.PRODUCT_1, 3);
			session.addProduct(Constants.PRODUCT_2, 2);
			session.addProduct(Constants.CAMPAIGN_1, 1);
			session.addProduct(Constants.CAMPAIGN_2, 2);
			
			Util.step();
			
			// now try to commit the session
			session.purchase();
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
}