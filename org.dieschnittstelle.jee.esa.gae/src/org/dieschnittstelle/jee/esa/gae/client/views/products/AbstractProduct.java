package org.dieschnittstelle.jee.esa.gae.client.views.products;

import java.io.Serializable;

public abstract class AbstractProduct implements Serializable {

   private static final long serialVersionUID = 6940403029597060153L;
   protected int id;

   private String name;

   private int price;

   public AbstractProduct() {

   }

   public AbstractProduct(String name) {
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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
