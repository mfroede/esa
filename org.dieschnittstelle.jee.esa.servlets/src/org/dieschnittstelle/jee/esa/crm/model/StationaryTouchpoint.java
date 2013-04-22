package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;

/**
 * @author kreutel
 */
public class StationaryTouchpoint extends AbstractTouchpoint  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6123798695442913993L;
	
	/**
	 * more than one pos may be located at some address
	 */
	private Address location;

	public StationaryTouchpoint() {
		
	}
	
	public StationaryTouchpoint(int erpPointOfSaleId) {
		this.setErpPointOfSaleId(erpPointOfSaleId);
	}

	public StationaryTouchpoint(int erpPointOfSaleId,String name,Address address) {
		super.setErpPointOfSaleId(erpPointOfSaleId);
		super.setName(name);
		this.setLocation(address);
	}
	
	public String toString() {
		return "{StationaryTouchpoint " + this.id + "/" + this.erpPointOfSaleId + " " + this.name + " " + this.location + "}";
	}
	
	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}
	
}
