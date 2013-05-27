package org.dieschnittstelle.jee.esa.crm.model;

import java.io.Serializable;

/**
 * a product bundle on the part of the crm system that tracks the number of units for some erpProductId and also tracks wheher the product is a campaign
 */
public class CrmProductBundle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5027719621777767575L;

	private int id;
	
	private int erpProductId;
	
	private int units;
	
	private boolean isCampaign;
	
	public CrmProductBundle(int erpProductId,int units) {
		this(erpProductId, units, false);
	}

	public CrmProductBundle(int erpProductId,int units,boolean isCampaign) {
		this.erpProductId = erpProductId;
		this.units = units;
		this.isCampaign = isCampaign;
	}

	public int getId() {
		return id;
	}

	public int getErpProductId() {
		return erpProductId;
	}

	public int getUnits() {
		return units;
	}

	public boolean isCampaign() {
		return isCampaign;
	}

}
