package org.dieschnittstelle.jee.esa.ejbs.client;

import org.dieschnittstelle.jee.esa.crm.model.Address;
import org.dieschnittstelle.jee.esa.crm.model.Customer;
import org.dieschnittstelle.jee.esa.crm.model.Gender;
import org.dieschnittstelle.jee.esa.crm.model.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.erp.model.Campaign;
import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.model.ProductBundle;
import org.dieschnittstelle.jee.esa.erp.model.ProductType;

/**
 * this class specifies a couple of entities for the domain objects that are used by the client classes
 */
public class Constants {
	
	/*
	 * the bean identifiers 
	 */
	//public static final String SHOPPING_CART_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/ShoppingCartStateful!org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote?stateful";
	public static final String SHOPPING_CART_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/shoppingCart!org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote?stateful";
	public static final String CAMPAIGN_TRACKING_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/CampaignTrackingSingleton!org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote"; 
	public static final String CUSTOMER_TRACKING_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/customerTrackingSystem!org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingRemote"; 
	public static final String STOCK_SYSTEM_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/stockSystem!org.dieschnittstelle.jee.esa.erp.ejbs.StockSystem";
	public static final String SHOPPING_SESSION_BEAN = "ejb:/org.dieschnittstelle.jee.esa.ejbs/shoppingSession!org.dieschnittstelle.jee.esa.shopping.ShoppingSessionFacade";
	/*
	 * constants for the objects that are dealt with in the different accessors to the beans
	 */

	public static StationaryTouchpoint TOUCHPOINT_1;

	public static StationaryTouchpoint TOUCHPOINT_2;
	
	public static IndividualisedProductItem PRODUCT_1;

	public static IndividualisedProductItem PRODUCT_2;
	
	public static Campaign CAMPAIGN_1;

	public static Campaign CAMPAIGN_2;
	
	public static Customer CUSTOMER_1;

	public static Customer CUSTOMER_2;
	
	// instantiate the constants
	static {
		
		Address addr1 = new Address("Luxemburger Straße", "10", "13353", "Berlin");
		TOUCHPOINT_1 = new StationaryTouchpoint(0, "BHT Mensa", addr1);
		
		Address addr2 = new Address("Leopoldplatz", "1", "13353", "Berlin");
		TOUCHPOINT_2 = new StationaryTouchpoint(1, "U Leopoldplatz", addr2);

		PRODUCT_1 = new IndividualisedProductItem("Schrippe",	ProductType.ROLL, 720);
		PRODUCT_1.setId(1);

		PRODUCT_2 = new IndividualisedProductItem("Kirschplunder",ProductType.PASTRY, 1080);
		PRODUCT_2.setId(2);

		CAMPAIGN_1 = new Campaign();
		CAMPAIGN_1.setId(3);
		CAMPAIGN_1.addBundle(new ProductBundle(PRODUCT_1, 5));
		
		CAMPAIGN_2 = new Campaign();
		CAMPAIGN_2.setId(4);
		CAMPAIGN_2.addBundle(new ProductBundle(PRODUCT_2, 2));

		CUSTOMER_1 = new Customer("Anna", "Musterfrau", Gender.W);

		CUSTOMER_2 = new Customer("Benedikt", "Mustermann", Gender.M);
	}
	
}
