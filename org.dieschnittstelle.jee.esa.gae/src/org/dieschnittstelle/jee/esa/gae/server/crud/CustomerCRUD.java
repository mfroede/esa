package org.dieschnittstelle.jee.esa.gae.server.crud;

import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;

public interface CustomerCRUD {	
	
	public Customer createCustomer(Customer customer);

	public Customer readCustomer(int id);

	public Customer updateCustomer(Customer customer);
		
	public Customer updateCustomerWithSleep(Customer customer,long sleep);
	
	public boolean deleteCustomer(int id);

}
