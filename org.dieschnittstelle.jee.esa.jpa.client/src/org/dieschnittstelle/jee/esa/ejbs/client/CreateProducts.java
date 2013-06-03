package org.dieschnittstelle.jee.esa.ejbs.client;

import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.*;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

public class CreateProducts {
	
	protected static Logger logger = Logger.getLogger(CreateProducts.class);
	
	public static void main(String[] args) {

		try {

			// obtain the beans using a jndi context
			Context context = new InitialContext();
			
			// TODO: lookup eines Remote Interface für CRUD bezüglich AbstractProduct
			
			// TODO: server-seitige Erzeugung von PRODUCT_1/2 und CAMPAIGN_1/2 durch Aufruf der Methoden des Remote Interface
			// PRODUCT_1 = ...
			// PRODUCT_2 = ...
			// CAMPAIGN_1 = ...
			// CAMPAIGN_2 = ...

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}


}
