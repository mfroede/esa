package org.dieschnittstelle.jee.esa.crm.entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * this is an abstraction over different touchpoints (with pos being the most
 * prominent one, others may be a service center, website, appsite, etc.)
 * 
 * @author kreutel
 * 
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class AbstractTouchpoint implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7618072642097421549L;

	protected int id = -1;

	/**
	 * the id of the PointOfSale from the erp data
	 */
	protected int erpPointOfSaleId;

	/**
	 * the name of the touchpoint
	 */
	protected String name;

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


	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof AbstractTouchpoint)) {
			return false;
		}

		return this.getId() == ((AbstractTouchpoint) obj).getId();
	}

}
