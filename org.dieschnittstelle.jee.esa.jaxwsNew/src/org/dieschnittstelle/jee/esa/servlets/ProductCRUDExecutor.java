package org.dieschnittstelle.jee.esa.servlets;

import java.util.ArrayList;
import java.util.List;

import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;
import org.jboss.logging.Logger;

/**
 * partial CRUD operations for AbstractTouchpoint objects which are read in /
 * written to a file
 * 
 * @author kreutel
 * 
 */
public class ProductCRUDExecutor {

	/**
	 * the logger
	 */
	protected static Logger logger = Logger
			.getLogger(ProductCRUDExecutor.class);

	/**
	 * the id counter
	 */
	private int currentProductId;

	/**
	 * the list of touchpoints that is managed by this class
	 */
	private List<AbstractProduct> products = new ArrayList<AbstractProduct>();

	/**
	 * create the executor passing a file
	 */
	public ProductCRUDExecutor() {
		currentProductId = 0;
		logger.info("<constructor>");
	}

	/**
	 * create a Product
	 */
	public AbstractProduct createProduct(AbstractProduct product) {
		logger.info("createTouchpoint(): " + product);

		// assign an id and add it to the list
		currentProductId++;
		product.setId(currentProductId);
		this.products.add(product);

		return product;
	}

	/**
	 * read all touchpoints
	 */
	public List<AbstractProduct> readAllProduct() {
		logger.info("readAllTouchpoints(): " + this.products);
		
		return this.products;
	}

}
