package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * this is an abstraction over different touchpoints (with pos being the most
 * prominent one, others may be a service center, website, appsite, etc.)
 * 
 * @author kreutel
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://dieschnittstelle.org/jee/esa/crm/model")
@XmlSeeAlso(StationaryTouchpoint.class)
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

	/*
	 * Ü2: kommentieren Sie diese Annotation aus
	 */
	//@XmlTransient
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

	@Override
	public String toString() {
		return "AbstractTouchpoint [id=" + id + ", erpPointOfSaleId="
				+ erpPointOfSaleId + ", name=" + name + ", customers="
				+ customers + "]";
	}

}
