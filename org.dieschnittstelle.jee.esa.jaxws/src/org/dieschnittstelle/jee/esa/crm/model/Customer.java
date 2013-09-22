package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


import org.apache.commons.lang.builder.EqualsBuilder;

/*
 * Ü2: ändern Sie die Klasse so, dass sie client-seitig in einem gleichnamigen Package wie server-seitig generiert wird
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(namespace = "http://dieschnittstelle.org/jee/esa/crm/model")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7461272049473919251L;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Gender gender;

	private String firstName;

	private String lastName;

	private String mobilePhoneId;

	private String email;

	private Address address;

	private Collection<AbstractTouchpoint> touchpoints = new HashSet<AbstractTouchpoint>();

	private AbstractTouchpoint preferredTouchpoint;

	private Collection<CustomerTransaction> transactions;
	
	public void addTouchpoint(AbstractTouchpoint touchpoint) {
		this.touchpoints.add(touchpoint);
	}
	
	public Customer() {
		
	}

	public Customer(String firstName, String lastName, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public Customer(String firstName, String lastName, Gender gender,
			String mobilePhoneId) {
		this(firstName, lastName, gender);
		this.mobilePhoneId = mobilePhoneId;
	}

	public Customer(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobilePhoneId() {
		return mobilePhoneId;
	}

	public void setMobilePhoneId(String mobilePhoneID) {
		this.mobilePhoneId = mobilePhoneID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Collection<AbstractTouchpoint> getTouchpoints() {
		return touchpoints;
	}

	public void setTouchpoints(Collection<AbstractTouchpoint> touchpoints) {
		this.touchpoints = touchpoints;
	}

	public AbstractTouchpoint getPreferredTouchpoint() {
		return preferredTouchpoint;
	}

	public void setPreferredTouchpoint(AbstractTouchpoint preferredTouchpoint) {
		this.preferredTouchpoint = preferredTouchpoint;
	}

	public String toString() {
		return "{Customer " + this.id + " " + this.firstName + " " + this.lastName
				+ " (" + this.gender + ") " + this.email + ", "
				+ this.mobilePhoneId + ", " + this.address + "}";
	}
	
	public void setGender(Gender gd) {
		this.gender = gd;
	}
	
	public Gender getGender() {
		return this.gender;
	}

	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}
	
}
