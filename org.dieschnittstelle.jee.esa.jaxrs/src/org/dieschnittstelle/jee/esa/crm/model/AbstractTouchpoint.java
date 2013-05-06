package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * this is an abstraction over different touchpoints (with pos being the most
 * prominent one, others may be a service center, website, appsite, etc.)
 * 
 * @author kreutel
 * 
 */
public abstract class AbstractTouchpoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5207353251688141788L;

	protected int id = -1;

	/**
	 * the id of the PointOfSale from the erp data
	 */
	protected int erpPointOfSaleId;

	/**
	 * the name of the touchpoint
	 */
	protected String name;

	/**
	 * the bidirectional association with the customers for this touchpoint
	 */
	private Collection<Customer> customers;

	public AbstractTouchpoint() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getErpPointOfSaleId() {
		return erpPointOfSaleId;
	}

	public void setErpPointOfSaleId(int erpPointOfSaleId) {
		this.erpPointOfSaleId = erpPointOfSaleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof AbstractTouchpoint)) {
			return false;
		}

		return this.getId() == ((AbstractTouchpoint) obj).getId();
	}

}
