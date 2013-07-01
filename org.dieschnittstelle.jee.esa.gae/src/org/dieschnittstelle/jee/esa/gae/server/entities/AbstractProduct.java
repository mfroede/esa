package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public abstract class AbstractProduct implements Serializable {

   private static final long serialVersionUID = 6940403029597060153L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;

   private String name;

   private int price;

   public AbstractProduct() {

   }

   public AbstractProduct(String name) {
      this.name = name;
   }

   public Key getId() {
      return id;
   }

   public void setId(Key id) {
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
