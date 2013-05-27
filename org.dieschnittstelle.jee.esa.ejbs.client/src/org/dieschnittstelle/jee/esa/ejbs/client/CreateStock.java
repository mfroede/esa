package org.dieschnittstelle.jee.esa.ejbs.client;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.erp.ejbs.StockSystem;

public class CreateStock {

	protected static Logger logger = Logger.getLogger(CreateStock.class);

	public static void main(String[] args) {

		// greifen Sie wie in den anderen Anwendungen auf die von Ihnen
		// erstellte StockSystem EJB zu
		StockSystem stockSystem = null;

		// fügen Sie die Produkte hinzu
		stockSystem.addToStock(Constants.PRODUCT_1,
				Constants.TOUCHPOINT_1.getId(), 100);
		stockSystem.addToStock(Constants.PRODUCT_2,
				Constants.TOUCHPOINT_1.getId(), 100);
		stockSystem.addToStock(Constants.PRODUCT_1,
				Constants.TOUCHPOINT_2.getId(), 100);
		stockSystem.addToStock(Constants.PRODUCT_2,
				Constants.TOUCHPOINT_2.getId(), 100);

		// und lassen Sie sich die Vorräte ausgeben
		int s1 = stockSystem.getUnitsOnStock(Constants.PRODUCT_1,
				Constants.TOUCHPOINT_1.getId());
		int s2 = stockSystem.getUnitsOnStock(Constants.PRODUCT_1,
				Constants.TOUCHPOINT_2.getId());
		int s3 = stockSystem.getUnitsOnStock(Constants.PRODUCT_2,
				Constants.TOUCHPOINT_1.getId());
		int s4 = stockSystem.getUnitsOnStock(Constants.PRODUCT_2,
				Constants.TOUCHPOINT_2.getId());

		logger.info("Vorraete: " + s1 + "/" + s2 + ", " + s3 + "/" + s4);
	}

}
