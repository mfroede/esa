package org.dieschnittstelle.jee.esa.jaxrs.client;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.jaxwsnew.ProductCRUDWebService;
import org.dieschnittstelle.jee.esa.jaxwsnew.ProductCRUDWebService_Service;
import org.taeglichmahl.crm.model.data.ProductType;

public class TestProductRESTService {

	protected static Logger logger = Logger.getLogger(TestProductRESTService.class);
	
	public static void main(String[] args) {
		
try {
			
			// create an instance of the client-side web service class
			ProductCRUDWebService_Service service = new ProductCRUDWebService_Service();
			// obtain an interface to the operations provided by the service
			ProductCRUDWebService serviceOperations = service.getProductCRUDWebServicePort();

			IndividualisedProductItem prod1 = new IndividualisedProductItem();
			prod1.setName("Schrippe");
			prod1.setProductType(ProductType.ROLL);
			prod1.setExpirationAfterStocked(720);

			prod1 = (IndividualisedProductItem) serviceOperations.createProduct(prod1);
			logger.info("created touchpoint: " + prod1);
			
			// 1) read out all touchpoints
			List<AbstractProduct> products = serviceOperations.readAllProducts().getItem();
			logger.info("read touchpoints: " + products);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
