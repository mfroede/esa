package org.dieschnittstelle.jee.esa.android.model.dto;

public class ProductBundleDTO {
   private long id;
   private ProductDTO product;
   private int units;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public ProductDTO getProduct() {
      return product;
   }

   public void setProduct(ProductDTO product) {
      this.product = product;
   }

   public int getUnits() {
      return units;
   }

   public void setUnits(int units) {
      this.units = units;
   }

}
