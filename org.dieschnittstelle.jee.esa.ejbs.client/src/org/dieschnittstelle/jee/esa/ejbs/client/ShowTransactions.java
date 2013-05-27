package org.dieschnittstelle.jee.esa.ejbs.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingRemote;

public class ShowTransactions {

	protected static Logger logger = Logger.getLogger(ShowCampaigns.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// obtain the beans using a jndi context
			Context context = new InitialContext();
			CustomerTrackingRemote customerTracking = (CustomerTrackingRemote) context
					.lookup(Constants.CUSTOMER_TRACKING_BEAN);
			logger.info("transactions are: "
					+ customerTracking.readAllTransactions());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
