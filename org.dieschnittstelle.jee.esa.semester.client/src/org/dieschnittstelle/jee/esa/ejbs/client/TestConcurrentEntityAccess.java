package org.dieschnittstelle.jee.esa.ejbs.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.ejbs.crud.CustomerCRUDRemote;
import org.dieschnittstelle.jee.esa.crm.entities.Customer;

public class TestConcurrentEntityAccess {

	protected static Logger logger = Logger
			.getLogger(TestConcurrentEntityAccess.class);

	public static void main(String[] args) {

		try {

			// obtain the beans using a jndi context
			Context context = new InitialContext();
			final CustomerCRUDRemote customerCRUD = (CustomerCRUDRemote) context
					.lookup(Constants.CUSTOMER_CRUD_BEAN);
			logger.debug("got customerCRUD: " + customerCRUD);

			// create a customer
			final Customer cust = customerCRUD
					.createCustomer(Constants.CUSTOMER_2);
			logger.info("created customer: " + cust);

			Util.step();

			// we start two threads that access the bean
			new Thread(new Runnable() {

				@Override
				public void run() {
					cust.setFirstName("Max");
					Customer mycust = customerCRUD.updateCustomerWithSleep(
							cust, 10000);
					logger.info("sleep10000: got customer: " + mycust);
				}
			}).start();
			
			// Util.step();
			// sleep a second before we start the second thread
			Thread.sleep(1000);

			// we start two threads that access the bean
			new Thread(new Runnable() {

				@Override
				public void run() {
					cust.setFirstName("Manfred");
					Customer mycust = customerCRUD.updateCustomerWithSleep(
							cust, 5000);
					logger.info("sleep5000: got customer: " + mycust);
				}
			}).start();
			
			Util.step();
			
			// once everything is done, we read out the customer again
			Customer finalcust = customerCRUD.readCustomer(cust.getId());
			logger.info("finally read customer for id " + cust.getId() + ": " + finalcust);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
