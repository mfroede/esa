package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;

public interface CustomerCRUD {

   public Customer createCustomer(Customer customer);

   public List<Customer> readAllCustomers();

   public Customer readCustomer(Long id);

   public Customer updateCustomer(Customer customer);

   public Customer updateCustomerWithSleep(Customer customer, long sleep);

   public boolean deleteCustomer(Long id);

}
