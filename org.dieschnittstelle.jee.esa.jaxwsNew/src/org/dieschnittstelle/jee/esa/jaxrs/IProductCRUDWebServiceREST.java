package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.List;

import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Products")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface IProductCRUDWebServiceREST {
	
	@GET
	public List<AbstractProduct> readAllProducts();
	
	@POST
	public AbstractProduct createProduct(AbstractProduct touchpoint); 
	
	
}
