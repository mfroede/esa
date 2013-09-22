package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.model.ProductType;
import org.dieschnittstelle.jee.esa.servlets.TouchpointCRUDExecutor;

/*
 * Ü2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDWebServiceImpl implements IProductCRUDWebService {
	
	protected static Logger logger = Logger.getLogger(ProductCRUDWebServiceImpl.class);
	
	private static int ID;

	private static List<IndividualisedProductItem> products = new ArrayList<IndividualisedProductItem>();
	
	static {
		products.add(new IndividualisedProductItem("Baguette",	ProductType.BREAD, 360));
	}

	public ProductCRUDWebServiceImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
		logger.info("<constructor>: " + servletContext + "/" + request);	
	}
	
	@Override
	@POST
	public IndividualisedProductItem createIndividualisedProductItem(IndividualisedProductItem item) {
		products.add(item);
		return item;
	}

	@Override
	@GET
	public List<AbstractProduct> readAllIndividualisedProductItems() {
		return (List)this.products;
	}


}
