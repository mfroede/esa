
package org.dieschnittstelle.jee.esa.crm.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stationaryTouchpoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stationaryTouchpoint">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dieschnittstelle.org/jee/esa/crm/model}abstractTouchpoint">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://dieschnittstelle.org/jee/esa/crm/model}address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stationaryTouchpoint", propOrder = {
    "location"
})
public class StationaryTouchpoint
    extends AbstractTouchpoint
{

    protected Address location;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setLocation(Address value) {
        this.location = value;
    }

}
