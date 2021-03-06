package org.dieschnittstelle.jee.esa.jaxwsnew;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2013-09-22T18:44:50.591+02:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "ProductCRUDWebService", 
                  wsdlLocation = "http://localhost:8080/org.dieschnittstelle.jee.esa.jaxwsNew/ProductCRUDWebService?wsdl",
                  targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxwsNew") 
public class ProductCRUDWebService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://dieschnittstelle.org/jee/esa/jaxwsNew", "ProductCRUDWebService");
    public final static QName ProductCRUDWebServicePort = new QName("http://dieschnittstelle.org/jee/esa/jaxwsNew", "ProductCRUDWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/org.dieschnittstelle.jee.esa.jaxwsNew/ProductCRUDWebService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProductCRUDWebService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/org.dieschnittstelle.jee.esa.jaxwsNew/ProductCRUDWebService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProductCRUDWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProductCRUDWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductCRUDWebService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductCRUDWebService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductCRUDWebService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProductCRUDWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ProductCRUDWebService
     */
    @WebEndpoint(name = "ProductCRUDWebServicePort")
    public ProductCRUDWebService getProductCRUDWebServicePort() {
        return super.getPort(ProductCRUDWebServicePort, ProductCRUDWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductCRUDWebService
     */
    @WebEndpoint(name = "ProductCRUDWebServicePort")
    public ProductCRUDWebService getProductCRUDWebServicePort(WebServiceFeature... features) {
        return super.getPort(ProductCRUDWebServicePort, ProductCRUDWebService.class, features);
    }

}
