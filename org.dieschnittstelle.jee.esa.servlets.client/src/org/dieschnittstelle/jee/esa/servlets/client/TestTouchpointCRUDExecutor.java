package org.dieschnittstelle.jee.esa.servlets.client;

import java.io.File;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.model.Address;
import org.dieschnittstelle.jee.esa.crm.model.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.servlets.TouchpointCRUDExecutor;

public class TestTouchpointCRUDExecutor {

	protected static Logger logger = Logger.getLogger(TestTouchpointCRUDExecutor.class);
	
	public static void main(String[] args) {
		
		// the file
		File datafile = new File("touchpoints.data");
		
		// create the executor
		TouchpointCRUDExecutor exec = new TouchpointCRUDExecutor(datafile);
		
		// load
		exec.load();
		
		exec.readAllTouchpoints();
		
		// create a touchpoint
		Address addr = new Address("Luxemburger Stra§e", "10", "13353", "Berlin");
		StationaryTouchpoint tp = new StationaryTouchpoint(-1, "Verkaufsstand BHT", addr);
		
		tp = (StationaryTouchpoint)exec.createTouchpoint(tp);
		
		exec.readAllTouchpoints();
		
		// delete the touchpoint
		exec.deleteTouchpoint(tp.getId());
				
		// read out again
		exec.readAllTouchpoints();
		
		// store
		exec.store();
		
		// create a new executor object
		exec = new TouchpointCRUDExecutor(datafile);
		
		// and read again
		exec.load();
			
		exec.readAllTouchpoints();
	}
	
}
