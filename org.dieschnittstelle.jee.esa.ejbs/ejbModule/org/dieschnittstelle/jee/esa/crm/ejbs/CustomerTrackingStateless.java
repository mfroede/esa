package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.dieschnittstelle.jee.esa.crm.model.CustomerTransaction;
import org.jboss.logging.Logger;

/**
 * allows read/write access to a customer's shopping history
 */
@Stateless
public class CustomerTrackingStateless implements CustomerTrackingRemote {

	protected static Logger logger = Logger
			.getLogger(CustomerTrackingStateless.class);

	/**
	 * as long as we do not actually persist data, we will use a static list of
	 * customer transactions
	 */
	private static final List<CustomerTransaction> transactions = new ArrayList<CustomerTransaction>();

	public CustomerTrackingStateless() {
		logger.info("<constructor>: " + this);
	}

	public void createTransaction(CustomerTransaction transaction) {
		logger.info("addTransaction(): " + transaction);
		transactions.add(transaction);
	}
	
	public List<CustomerTransaction> readAllTransactions() {
		return transactions;
	}

	@PostConstruct
	public void initialise() {
		logger.info("@PostConstruct");
	}

	@PreDestroy
	public void finalise() {
		logger.info("@PreDestroy");
	}

}
