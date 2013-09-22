package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.jboss.logging.Logger;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;

public class ProductCRUDWebServiceRESTImpl implements IProductCRUDWebServiceREST {
	
	protected static Logger logger = Logger.getLogger(ProductCRUDWebServiceRESTImpl.class);
	
	private static int ID;

	private static List<AbstractProduct> products = new ArrayList<AbstractProduct>();
	
	public ProductCRUDWebServiceRESTImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
		logger.info("<constructor ProductCRUDWebServiceRESTImpl>: " + servletContext + "/" + request);	
	}
	

	@Override
	public List<AbstractProduct> readAllProducts() {
		return (List)this.products;
	}

	@Override
	public AbstractProduct createProduct(AbstractProduct product) {
		this.products.add(product);
		return product;	
	}

}
