package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.appengine.api.datastore.Key;

@Entity
@XmlRootElement
public class Address extends Location implements Serializable {

   protected static Logger logger = Logger.getLogger(Address.class.getName());

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;

   public Key getId() {
      return id;
   }

   public void setId(Key id) {
      this.id = id;
   }

   private String street;

   private String houseNr;

   private String zipCode;

   private String city;

   public Address() {
      logger.info("<constructor>");
   }

   public Address(String street, String houseNr, String zipCode, String city) {
      this.street = street;
      this.houseNr = houseNr;
      this.zipCode = zipCode;
      this.city = city;
   }

   public Address(String street, String houseNr, String zipCode, String city, long geoLat, long geoLong) {
      this(street, houseNr, zipCode, city);
      this.setGeoLat(geoLat);
      this.setGeoLong(geoLong);
   }

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getHouseNr() {
      return houseNr;
   }

   public void setHouseNr(String houseNr) {
      this.houseNr = houseNr;
   }

   public String getZipCode() {
      return zipCode;
   }

   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   @Override
   public String toString() {
      return "{Address " + this.getId() + ", " + this.street + " " + this.houseNr + ", " + this.zipCode + " " + this.city + "}";
   }

   @Override
   public boolean equals(Object other) {
      return EqualsBuilder.reflectionEquals(this, other);
   }

   @Override
   public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
   }

}
