package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProduct implements Serializable {

   private static final long serialVersionUID = 6940403029597060153L;

   @Id
   private Integer id;

   private String name;

   public AbstractProduct() {

   }

   public AbstractProduct(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

}
