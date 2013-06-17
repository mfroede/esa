package org.dieschnittstelle.jee.esa.crm.entities;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @author kreutel
 */
public class StationaryTouchpoint extends AbstractTouchpoint  implements Serializable {
	
	protected static Logger logger = Logger.getLogger(StationaryTouchpoint.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6123798695442913993L;
	
	private Address location;
	
	public StationaryTouchpoint() {
		logger.info("<constructor>");
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
