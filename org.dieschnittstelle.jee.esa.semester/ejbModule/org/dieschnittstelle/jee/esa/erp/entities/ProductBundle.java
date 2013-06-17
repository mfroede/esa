package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class ProductBundle implements Serializable {

   private static final long serialVersionUID = 1501911067906145681L;

   @Id
   private Integer id;

   @OneToOne
   private IndividualisedProductItem product;

   private int units;

   public ProductBundle() {
   }

   public ProductBundle(IndividualisedProductItem product, int units) {
      this.product = product;
      this.units = units;
   }

   public IndividualisedProductItem getProduct() {
      return this.product;
   }

   public void setProduct(IndividualisedProductItem product) {
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

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
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
