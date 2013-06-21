package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.server.entities.CustomerTransaction;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CustomerTransactionCRUDImpl implements CustomerTransactionCRUD {

	protected static Logger logger = Logger
			.getLogger(CustomerTransactionCRUDImpl.class.getName());

	EntityManager em = EMF.get().createEntityManager();

	@Override
	public boolean createTransaction(CustomerTransaction transaction) {
		logger.info("createTransaction(): " + transaction);

		// check whether the transaction fields are detached or not
		logger.info("createTransaction(): customer attached (before): "
				+ em.contains(transaction.getCustomer()));
		logger.info("createTransaction(): touchpoint attached (before): "
				+ em.contains(transaction.getTouchpoint()));
		/*
		 * Ü1.1
		 */
		// persist each bundle
		// for (CrmProductBundle bundle : transaction.getProducts()) {
		// logger.info("createTransaction(): will manually persist bundle: " +
		// bundle);
		// em.persist(bundle);
		// logger.info("createTransaction(): persisted bundle: " + bundle);
		// }

		// persit the transaction
		em.persist(transaction);

		logger.info("createTransaction(): done.");

		return true;
	}

	@Override
	public Collection<CustomerTransaction> readAllTransactionsForTouchpoint(
			AbstractTouchpoint touchpoint) {
		logger.info("readAllTransactionsForTouchpoint(): " + touchpoint);
		// check the transactions on the touchpoint
		logger.info("readAllTransactionsForTouchpoint(): before merge transactions are: "
				+ touchpoint.getTransactions());

		touchpoint = em.find(AbstractTouchpoint.class, touchpoint.getId());
		logger.info("touchpoint queried.");

		// now read out the transactions
		Collection<CustomerTransaction> trans = touchpoint.getTransactions();
		logger.info("readAllTransactionsForTouchpoint(): transactions are: "
				+ trans);
		logger.info("readAllTransactionsForTouchpoint(): class is: "
				+ (trans == null ? "<null pointer>" : String.valueOf(trans
						.getClass())));

		return trans;
	}

	@Override
	public Collection<CustomerTransaction> readAllTransactionsForCustomer(
			Customer customer) {
		logger.info("readAllTransactionsForCustomer(): " + customer);

		Query query = em
				.createQuery("SELECT t FROM CustomerTransaction t WHERE t.customer = "
						+ customer.getId());
		logger.info("readAllTransactionsForCustomer(): created query: " + query);

		List<CustomerTransaction> trans = query.getResultList();
		logger.info("readAllTransactionsForCustomer(): " + trans);
		logger.info("readAllTransactionsForCustomer(): class is: "
				+ (trans == null ? "<null pointer>" : String.valueOf(trans
						.getClass())));

		return trans;
	}

	@Override
	public List<CustomerTransaction> readAllTransactionsForTouchpointAndCustomer(
			AbstractTouchpoint touchpoint, Customer customer) {
		logger.info("readAllTransactionsForTouchpointAndCustomer(): "
				+ touchpoint + " / " + customer);

		Query query = em
				.createQuery("SELECT t FROM CustomerTransaction t WHERE t.customer = "
						+ customer.getId()
						+ " AND t.touchpoint = "
						+ touchpoint.getId());
		logger.info("readAllTransactionsForTouchpointAndCustomer(): created query: "
				+ query);

		List<CustomerTransaction> trans = query.getResultList();
		logger.info("readAllTransactionsForTouchpointAndCustomer(): " + trans);
		logger.info("readAllTransactionsForTouchpointAndCustomer(): class is: "
				+ (trans == null ? "<null pointer>" : String.valueOf(trans
						.getClass())));

		return trans;
	}

}
