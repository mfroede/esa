package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CustomerCRUDImpl implements CustomerCRUD {

	protected static final Logger logger = Logger
			.getLogger(CustomerCRUDImpl.class.getName());

	EntityManager em = EMF.get().createEntityManager();

	@Override
	public Customer createCustomer(Customer customer) {
		logger.info("createCustomer(): before persist(): " + customer);
		em.persist(customer);
		em.close();
		logger.info("createdCustomer(): after persist(): " + customer);
		return customer;
	}

	@Override
	public Customer readCustomer(Long id) {
		logger.info("readCustomer() id: " + id);

		Customer customer = em.find(Customer.class, id);
		em.close();

		logger.info("readCustomer() customer: " + customer);

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		logger.info("updateCustomer(): before merge(): " + customer);
		customer = em.merge(customer);
		em.close();

		logger.info("updateCustomer(): after merge(): " + customer);
		return customer;
	}

	@Override
	public Customer updateCustomerWithSleep(Customer customer, long sleep) {
		logger.info("sleep" + sleep + "@" + this + ": entity manager is: " + em);
		logger.info("sleep" + sleep + "@" + this
				+ ": before merge(): got remote: " + customer);
		// we read out the customer using the provided method

		customer = em.merge(customer);
		em.close();
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
	public boolean deleteCustomer(Long id) {
		logger.info("deleteCustomer(): " + id);

		em.remove(em.find(Customer.class, id));
		em.close();

		logger.info("deleteCustomer(): done");

		return true;
	}

	@Override
	public List<Customer> readAllCustomers() {
		CriteriaQuery<Customer> criteria = em.getCriteriaBuilder().createQuery(
				Customer.class);
		criteria.select(criteria.from(Customer.class));
		List<Customer> customers = em.createQuery(criteria).getResultList();
		return customers;
	}

}
