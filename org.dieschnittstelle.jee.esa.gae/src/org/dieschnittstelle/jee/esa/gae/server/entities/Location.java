package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@MappedSuperclass
public class Location implements Serializable {

   protected static Logger logger = Logger.getLogger(Location.class.getName());
   private static final long serialVersionUID = -131090102062445239L;

   private int id = -1;

   private double geoLat;

   private double geoLong;

   @Id
   @GeneratedValue
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public double getGeoLat() {
      return geoLat;
   }

   public void setGeoLat(double geoLat) {
      this.geoLat = geoLat;
   }

   public double getGeoLong() {
      return geoLong;
   }

   public void setGeoLong(double d) {
      this.geoLong = d;
   }

   @Override
   public boolean equals(Object other) {
      return EqualsBuilder.reflectionEquals(this, other);
   }

   @Override
   public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
   }

   /*
    * lifecycle logging
    */

   @PostLoad
   public void onPostLoad() {
      logger.info("@PostLoad: " + this);
   }

   @PostPersist
   public void onPostPersist() {
      logger.info("@PostPersist: " + this);
   }

   @PostRemove
   public void onPostRemove() {
      logger.info("@PostRemove: " + this);
   }

   @PostUpdate
   public void onPostUpdate() {
      logger.info("@PostUpdate: " + this);
   }

   @PrePersist
   public void onPrePersist() {
      logger.info("@PrePersist: " + this);
   }

   @PreRemove
   public void onPreRemove() {
      logger.info("@PreRemove: " + this);
   }

   @PreUpdate
   public void onPreUpdate() {
      logger.info("@PreUpdate: " + this);
   }

}
