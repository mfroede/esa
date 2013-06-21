package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CustomerCRUDImpl implements CustomerCRUD {

	protected static Logger logger = Logger.getLogger(CustomerCRUDImpl.class
			.getName());

	EntityManager em = EMF.get().createEntityManager();

	@Override
	public Customer createCustomer(Customer customer) {
		logger.info("createCustomer(): before persist(): " + customer);
		em.persist(customer);
		logger.info("createdCustomer(): after persist(): " + customer);
		return customer;
	}

	@Override
	public Customer readCustomer(int id) {
		logger.info("readCustomer(): " + id);

		Customer customer = em.find(Customer.class, id);

		logger.info("readCustomer(): " + customer);

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		logger.info("updateCustomer(): before merge(): " + customer);
		customer = em.merge(customer);

		logger.info("updateCustomer(): after merge(): " + customer);
		return customer;
	}

	@Override
	public Customer updateCustomerWithSleep(Customer customer, long sleep) {
		logger.info("sleep" + sleep + "@" + this + ": entity manager is: " + em);
		logger.info("sleep" + sleep + "@" + this
				+ ": before merge(): got remote: " + customer);
		// we read out the customer using the provided method
		logger.info("sleep" + sleep + "@" + this
				+ ": before merge(): got local: "
				+ readCustomer(customer.getId()));

		customer = em.merge(customer);
		logger.info("sleep" + sleep + "@" + this + ": after merge(): "
				+ customer);

		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("sleep" + sleep + "@" + this + ": after sleep(): "
				+ customer);

		return customer;
	}

	@Override
	public boolean deleteCustomer(int id) {
		logger.info("deleteCustomer(): " + id);

		em.remove(em.find(Customer.class, id));

		logger.info("deleteCustomer(): done");

		return true;
	}

}
