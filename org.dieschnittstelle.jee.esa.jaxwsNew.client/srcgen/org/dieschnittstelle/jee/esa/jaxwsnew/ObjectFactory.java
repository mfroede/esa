
package org.dieschnittstelle.jee.esa.jaxwsnew;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.model.AbstractProductArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.jaxwsnew package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateProduct_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxwsNew", "createProduct");
    private final static QName _CreateProductResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxwsNew", "createProductResponse");
    private final static QName _ReadAllProductsResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxwsNew", "readAllProductsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.jaxwsnew
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxwsNew", name = "createProduct")
    public JAXBElement<AbstractProduct> createCreateProduct(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_CreateProduct_QNAME, AbstractProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxwsNew", name = "createProductResponse")
    public JAXBElement<AbstractProduct> createCreateProductResponse(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_CreateProductResponse_QNAME, AbstractProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProductArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxwsNew", name = "readAllProductsResponse")
    public JAXBElement<AbstractProductArray> createReadAllProductsResponse(AbstractProductArray value) {
        return new JAXBElement<AbstractProductArray>(_ReadAllProductsResponse_QNAME, AbstractProductArray.class, null, value);
    }

}
