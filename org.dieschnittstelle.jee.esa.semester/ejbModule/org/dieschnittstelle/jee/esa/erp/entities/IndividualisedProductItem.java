package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class IndividualisedProductItem extends AbstractProduct implements Serializable {

   private static final long serialVersionUID = 5109263395081656350L;

   @Enumerated
   private ProductType productType;

   private int expirationAfterStocked;

   public IndividualisedProductItem() {

   }

   public IndividualisedProductItem(String name, ProductType type, int expirationAfterStocked) {
      super(name);
      this.productType = type;
      this.expirationAfterStocked = expirationAfterStocked;
   }

   public ProductType getProductType() {
      return productType;
   }

   public void setProductType(ProductType productType) {
      this.productType = productType;
   }

   public int getExpirationAfterStocked() {
      return expirationAfterStocked;
   }

   public void setExpirationAfterStocked(int expirationAfterStocked) {
      this.expirationAfterStocked = expirationAfterStocked;
   }

   @Override
   public String toString() {
      return "{IProductItem " + this.getId() + ", " + this.getName() + ", " + this.productType + "}";
   }

   @Override
   public boolean equals(Object other) {
      return EqualsBuilder.reflectionEquals(this, other);
   }

   @Override
   public int hashCode() {
      int code = HashCodeBuilder.reflectionHashCode(this);
      System.out.println("hashCode of " + this + ": " + hashCode());

      return code;
   }
}
