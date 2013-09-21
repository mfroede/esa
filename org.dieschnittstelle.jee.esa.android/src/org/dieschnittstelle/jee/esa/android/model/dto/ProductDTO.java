package org.dieschnittstelle.jee.esa.android.model.dto;

public abstract class ProductDTO {

   private String name;

   private int price;

   public ProductDTO(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

}
