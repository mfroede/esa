
package org.dieschnittstelle.jee.esa.erp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.taeglichmahl.crm.model.data.ProductType;


/**
 * <p>Java class for individualisedProductItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="individualisedProductItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dieschnittstelle.org/jee/esa/erp/model}abstractProduct">
 *       &lt;sequence>
 *         &lt;element name="productType" type="{http://taeglichmahl.org/crm/model/data}productType" minOccurs="0"/>
 *         &lt;element name="expirationAfterStocked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "individualisedProductItem", propOrder = {
    "productType",
    "expirationAfterStocked"
})
public class IndividualisedProductItem
    extends AbstractProduct
{

    protected ProductType productType;
    protected int expirationAfterStocked;

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductType }
     *     
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType }
     *     
     */
    public void setProductType(ProductType value) {
        this.productType = value;
    }

    /**
     * Gets the value of the expirationAfterStocked property.
     * 
     */
    public int getExpirationAfterStocked() {
        return expirationAfterStocked;
    }

    /**
     * Sets the value of the expirationAfterStocked property.
     * 
     */
    public void setExpirationAfterStocked(int value) {
        this.expirationAfterStocked = value;
    }

}
