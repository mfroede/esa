package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1251851309422364868L;

	private int id;

	private Date date;

	private Customer customer;

	private AbstractTouchpoint touchpoint;

	private int value;

	private boolean completed;
	
	private List<CrmProductBundle> products = new ArrayList<CrmProductBundle>();

	public CustomerTransaction() {

	}
	
	public CustomerTransaction(Customer customer,AbstractTouchpoint tp,List<CrmProductBundle> products) {
		this.customer = customer;
		this.touchpoint = tp;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AbstractTouchpoint getTouchpoint() {
		return touchpoint;
	}

	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		this.touchpoint = touchpoint;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String toString() {
		return "{CustomerTransaction " + this.id + " " + this.customer + " "
				+ this.touchpoint + ", " + this.products + "}";
	}

	public List<CrmProductBundle> getProducts() {
		return products;
	}

	public void setProducts(List<CrmProductBundle> products) {
		this.products = products;
	}

}
