package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -131090102062445239L;

	private int id;
	
	private long geoLat;
	
	private long geoLong;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public long getGeoLat() {
		return geoLat;
	}

	public void setGeoLat(long geoLat) {
		this.geoLat = geoLat;
	}

	public long getGeoLong() {
		return geoLong;
	}

	public void setGeoLong(long geoLong) {
		this.geoLong = geoLong;
	}
	
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}
	
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
