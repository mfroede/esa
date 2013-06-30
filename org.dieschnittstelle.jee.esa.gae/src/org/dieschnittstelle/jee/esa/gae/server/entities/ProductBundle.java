package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ProductBundle implements Serializable {

   private static final long serialVersionUID = 1501911067906145681L;

   private Integer id;

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
