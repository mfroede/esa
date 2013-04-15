package org.dieschnittstelle.jee.esa.basics.reflection;

import org.dieschnittstelle.jee.esa.basics.IConsumable;

public class Chocolate implements IConsumable {

	private int units;
	
	private String brandname;
	
	private int price;
	
	@Override
	public void acquire(int units,String brandname) {
		this.units = units;
		this.brandname = brandname;
	}

	@Override
	public void consume(int unitsToConsume) {
		if (unitsToConsume > this.units) {
			throw new RuntimeException(
					"You cannot consume more than what is available. Got: "
							+ unitsToConsume
							+ " units to consume, but have available only: "
							+ this.units);
		}
		this.units -= unitsToConsume;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUnits() {
		return this.units;
	}
	
	@Override
	public String toString() {
		return String.format("{Chocolate %s %d %d}", this.brandname, this.units, this.price);
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
