package org.dieschnittstelle.jee.esa.crm.entities;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;

public class MobileTouchpoint extends AbstractTouchpoint {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1846278142699684394L;


	protected static Logger logger = Logger.getLogger(MobileTouchpoint.class);
	

	private Collection<String> mobilePhoneIds = new HashSet<String>();

	public MobileTouchpoint() {
		logger.info("<constructor>");
	}

	public MobileTouchpoint(String mobilePhoneId) {
		this.addMobilePhoneId(mobilePhoneId);
	}

	public Collection<String> getMobilePhoneIds() {
		return mobilePhoneIds;
	}

	public void addMobilePhoneId(String mobilePhoneId) {
		this.mobilePhoneIds.add(mobilePhoneId);
	}

	public String toString() {
		return "{MobileTouchpoint " + this.id + "/" + this.erpPointOfSaleId + " " + this.mobilePhoneIds + "}";
	}
	
}
