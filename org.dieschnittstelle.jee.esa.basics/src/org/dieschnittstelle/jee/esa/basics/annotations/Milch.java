package org.dieschnittstelle.jee.esa.basics.annotations;

import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs.DisplayType;

@Consumable
public class Milch {

	@Units
	@DisplayAs(displayType=DisplayType.VALUE)
	private int menge;

	@Brandname
	@DisplayAs(displayType=DisplayType.BOTH)
	private String markenname;

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getMarkenname() {
		return markenname;
	}

	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}

	@Consume
	public void trinken(int unitsToConsume) {
		if (unitsToConsume > this.menge) {
			throw new RuntimeException(
					"You cannot consume more than what is available. Got: "
							+ unitsToConsume
							+ " units to consume, but have available only: "
							+ this.menge);
		}
		this.menge -= unitsToConsume;
	}

	@Acquire
	public void einkaufen(int units, String brandname) {
		this.markenname = brandname;
		this.menge = units;
	}
	
	@Dispose
	public void wegschmeissen() {
		
	}
	
	/**
	 * our own toString method
	 */
	public String toString() {
		return "{Milch " + this.markenname + " " + this.menge + "}";
	}

}
