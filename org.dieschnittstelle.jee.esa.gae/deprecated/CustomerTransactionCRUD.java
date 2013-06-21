package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.Collection;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.server.entities.CustomerTransaction;

public interface CustomerTransactionCRUD {
	
	public Collection<CustomerTransaction> readAllTransactionsForTouchpoint(AbstractTouchpoint touchpoint);

	public Collection<CustomerTransaction> readAllTransactionsForCustomer(Customer customer);

	public Collection<CustomerTransaction> readAllTransactionsForTouchpointAndCustomer(AbstractTouchpoint touchpoint,Customer customer);

	boolean createTransaction(CustomerTransaction transaction);

}
