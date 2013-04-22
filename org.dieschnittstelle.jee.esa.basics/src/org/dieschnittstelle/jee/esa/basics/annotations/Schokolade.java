package org.dieschnittstelle.jee.esa.basics.annotations;

import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs.DisplayType;

@Consumable
public class Schokolade {

	@Units
	@DisplayAs(displayType=DisplayType.BOTH)
	private int anzahlStuecke;

	private String marke;

	public int getAnzahlStuecke() {
		return anzahlStuecke;
	}

	public void setAnzahlStuecke(int anzahlStuecke) {
		this.anzahlStuecke = anzahlStuecke;
	}

	@Brandname
	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	@Acquire
	public void erwerben(int units, String name) {
		this.anzahlStuecke = units;
		this.marke = name;
	}

	@Consume
	public void naschen(int unitsToConsume) {
		if (unitsToConsume > this.anzahlStuecke) {
			throw new RuntimeException(
					"You cannot consume more than what is available. Got: "
							+ unitsToConsume
							+ " units to consume, but have available only: "
							+ this.anzahlStuecke);
		}
		this.anzahlStuecke -= unitsToConsume;
	}
	
	@Dispose
	public void entsorgen() {
		
	}

	/**
	 * toString
	 */
	public String toString() {
		return "{Schokolade " + this.marke + " " + this.anzahlStuecke + "}";
	}
}
