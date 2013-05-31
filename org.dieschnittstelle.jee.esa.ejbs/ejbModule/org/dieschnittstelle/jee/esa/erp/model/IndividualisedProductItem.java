package org.dieschnittstelle.jee.esa.erp.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class IndividualisedProductItem extends AbstractProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5109263395081656350L;

	private ProductType productType;

	private int expirationAfterStocked;
	
	public IndividualisedProductItem() {
		
	}
	
	public IndividualisedProductItem(String name,ProductType type,int expirationAfterStocked) {
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
	
	public String toString() {
		return "{IProductItem " + this.getId() + ", " + this.getName() + ", " + this.productType + "}";
	}

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + expirationAfterStocked;
      result = prime * result + ((productType == null) ? 0 : productType.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      IndividualisedProductItem other = (IndividualisedProductItem) obj;
      if (expirationAfterStocked != other.expirationAfterStocked)
         return false;
      if (productType != other.productType)
         return false;
      return true;
   }
	
//	public boolean equals(Object other) {
//		return EqualsBuilder.reflectionEquals(this, other);
//	}
//	
//	public int hashCode() {
//		int code = HashCodeBuilder.reflectionHashCode(this);
//		System.out.println("hashCode of " + this + ": " + hashCode());
//		
//		return code;
//	}

}
