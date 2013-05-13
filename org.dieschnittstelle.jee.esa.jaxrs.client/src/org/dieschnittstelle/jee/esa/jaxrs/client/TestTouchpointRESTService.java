package org.dieschnittstelle.jee.esa.jaxrs.client;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.Address;
import org.dieschnittstelle.jee.esa.crm.model.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.jaxrs.ITouchpointCRUDWebService;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class TestTouchpointRESTService {
	
	protected static Logger logger = Logger
			.getLogger(TestTouchpointRESTService.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * register jackson as reader and writer for json
		 */
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());		
		// the MessageBodyReader must be added explicitly to the provider factory. Here, we use the jackson implementation
		ResteasyProviderFactory.getInstance().addMessageBodyReader(JacksonJaxbJsonProvider.class);
		ResteasyProviderFactory.getInstance().addMessageBodyWriter(JacksonJaxbJsonProvider.class);
		
		/*
		 * create a client for the web service passing the interface
		 */
		ITouchpointCRUDWebService serviceClient = ProxyFactory.create(ITouchpointCRUDWebService.class,
				"http://localhost:8080/org.dieschnittstelle.jee.esa.jaxrs",
				new ApacheHttpClient4Executor());
				
		// 1) read out all touchpoints
		List<StationaryTouchpoint> touchpoints = serviceClient.readAllTouchpoints();
		logger.info("read touchpoints: " + touchpoints);

		// 2) delete the touchpoint after next console input
		if (touchpoints != null && touchpoints.size() > 0) {
			try {
				System.out.println("/>");
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StationaryTouchpoint tp = (StationaryTouchpoint)touchpoints.get(0);
			serviceClient.deleteTouchpoint(tp.getId());
			logger.info("deleted touchpoint: " + tp);
		}
		else {
			logger.warn("no touchpoints available for deletion...");
		}

		// 3) wait for input and create a new touchpoint
		try {
			System.out.println("/>");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Address addr = new Address("Luxemburger Straße", "10", "13353",
				"Berlin");
		StationaryTouchpoint tp = new StationaryTouchpoint(-1,
				"BHT Verkaufsstand", addr);

		tp = serviceClient.createTouchpoint(tp);
		logger.info("created touchpoint: " + tp);

		/*
		 * 4) wait for input and... 
		 */
		try {
			System.out.println("/>");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// change the name
		tp.setName("BHT Mensa");

		/*
		 * Ü1: add a call to the update method, passing tp
		 */
	}

}
