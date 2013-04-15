package org.dieschnittstelle.jee.esa.basics;

public interface IConsumable {
	
	public void acquire(int units,String brandname);
	
	public void consume(int units);
	
	public void dispose();
	
	public int getUnits();
	
	public String getBrandname();
		
}
