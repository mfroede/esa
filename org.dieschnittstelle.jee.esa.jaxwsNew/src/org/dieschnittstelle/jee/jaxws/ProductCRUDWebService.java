package org.dieschnittstelle.jee.jaxws;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.jaxrs.IProductCRUDWebServiceREST;
import org.dieschnittstelle.jee.esa.servlets.ProductCRUDExecutor;
import org.jboss.logging.Logger;

@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxwsNew", serviceName = "ProductCRUDWebService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class ProductCRUDWebService {

	protected static Logger logger = Logger
			.getLogger(ProductCRUDWebService.class);
	
	@Resource
	private WebServiceContext wscontext;
	
	public ProductCRUDWebService() {
		logger.info("<constructor>");
	}
	
	@PostConstruct
	@WebMethod(exclude = true)
	public void initialiseContext() {
		logger.info("@PostConstruct: the wscontext is: " + wscontext);

		// we cannot read out any context attributes (ServletContext,
		// HttpServletRequest) from the WebServiceContext as this is only
		// allowed from a thread that actually handles a particular request to a
		// service operation
		// wscontext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
	}
	
	@WebMethod
	public List<AbstractProduct> readAllProducts() {
		logger.info("readAllProducts()");

		logger.info("readAllProducts(): I am: " + this);
		
		// we obtain the servlet context from the wscontext
		ServletContext ctx = (ServletContext) wscontext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		logger.info("readAllProducts(): servlet context is: " + ctx);
		// we also read out the http request
		HttpServletRequest httpRequest = (HttpServletRequest) wscontext.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		logger.info("readAllProducts(): servlet request is: " + httpRequest);

		ProductCRUDExecutor productCRUD = (ProductCRUDExecutor) ctx.getAttribute("ProductCRUD");
		logger.info("readAllTouchpoints(): read touchpointCRUD from servletContext: " + productCRUD);
		
		// check that more than one requests is handled by the same instance of this class simulataneously
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return productCRUD.readAllProduct();
	}

	@WebMethod
	public AbstractProduct createProduct(AbstractProduct product) {
		// obtain the CRUD executor from the servlet context
		ProductCRUDExecutor productCRUD = (ProductCRUDExecutor) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("ProductCRUD");

		return (AbstractProduct) productCRUD.createProduct(product);
	}
}
