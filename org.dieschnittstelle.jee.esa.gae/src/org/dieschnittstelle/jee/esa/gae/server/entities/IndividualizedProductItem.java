package org.dieschnittstelle.jee.esa.gae.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.appengine.api.datastore.Key;

@Entity
public class IndividualizedProductItem extends AbstractProduct {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Key id;

   @Override
   public Key getId() {
      return id;
   }

   @Override
   public void setId(Key id) {
      this.id = id;
   }

}
