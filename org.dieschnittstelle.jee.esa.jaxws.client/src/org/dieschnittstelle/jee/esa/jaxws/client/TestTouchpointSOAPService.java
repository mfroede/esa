package org.dieschnittstelle.jee.esa.jaxws.client;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.jaxws.Address;
import org.dieschnittstelle.jee.esa.jaxws.TouchpointCRUDWebService;
import org.dieschnittstelle.jee.esa.jaxws.TouchpointCRUDWebServiceSOAP;

public class TestTouchpointSOAPService {

	protected static Logger logger = Logger
			.getLogger(TestTouchpointSOAPService.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// create an instance of the client-side web service class
			TouchpointCRUDWebService service = new TouchpointCRUDWebService();
			// obtain an interface to the operations provided by the service
			TouchpointCRUDWebServiceSOAP serviceOperations = service.getTouchpointCRUDWebServiceSOAPPort();

			// 1) read out all touchpoints
			List<AbstractTouchpoint> touchpoints = serviceOperations
					.readAllTouchpoints().getItem();
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

				StationaryTouchpoint tp = (StationaryTouchpoint) touchpoints
						.get(0);
				serviceOperations.deleteTouchpoint(tp.getId());
				logger.info("deleted touchpoint: " + tp);
			} else {
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

			Address addr = new Address();
			addr.setStreet("Luxemburger Straße");
			addr.setHouseNr("10");
			addr.setZipCode("13353");
			addr.setCity("Berlin");
			StationaryTouchpoint tp = new StationaryTouchpoint();
			tp.setId(-1);
			tp.setName("BHT SOAP Store");
			tp.setLocation(addr);

			tp = (StationaryTouchpoint) serviceOperations.createTouchpoint(tp);
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
			 * Ü3: add a call to the update method of the web service, passing tp
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
