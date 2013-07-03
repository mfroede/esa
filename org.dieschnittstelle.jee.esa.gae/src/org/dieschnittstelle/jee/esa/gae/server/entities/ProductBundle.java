package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.appengine.api.datastore.Key;

@Entity
@XmlRootElement
public class ProductBundle implements Serializable {

   private static final long serialVersionUID = 1501911067906145681L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;

   public Key getId() {
      return id;
   }

   public void setId(Key id) {
      this.id = id;
   }

   @OneToOne(cascade = { CascadeType.ALL })
   private IndividualizedProductItem product;

   private int units;

   public ProductBundle() {
   }

   public ProductBundle(IndividualizedProductItem product, int units) {
      this.product = product;
      this.units = units;
   }

   public IndividualizedProductItem getProduct() {
      return this.product;
   }

   public void setProduct(IndividualizedProductItem product) {
      this.product = product;
   }

   public int getUnits() {
      return this.units;
   }

   public void setUnits(int units) {
      this.units = units;
   }

   @Override
   public String toString() {
      return "{" + this.product + " (" + this.units + ")}";
   }

   @Override
   public boolean equals(Object other) {
      return EqualsBuilder.reflectionEquals(this, other);
   }

   @Override
   public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this, new String[] { "id" });
   }

}
