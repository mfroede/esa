package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class CampaignExecution implements Serializable {

   private static final long serialVersionUID = 5077516349500947392L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   private long touchpointId;
   private long campaignId;

   public void setUnits(int units) {
      this.units = units;
   }

   public void setDuration(long duration) {
      this.duration = duration;
   }

   private int units;

   private final long startDate = System.currentTimeMillis();

   private long duration;

   public int getUnits() {
      return units;
   }

   public long getStartDate() {
      return startDate;
   }

   public long getDuration() {
      return duration;
   }

   public int getUnitsLeft() {
      return unitsLeft;
   }

   /**
    * track the units that are left for this execution
    */
   private int unitsLeft;

   /**
    * purchase a given number of units
    */
   public void purchase(int units) {
      if (duration != -1 && System.currentTimeMillis() - startDate > duration) {
         throw new RuntimeException("campaign for " + getCampaignId() + " has expired!");
      }

      if (units > unitsLeft) {
         throw new RuntimeException("number " + units + " of units to be purchased exceeds the number " + unitsLeft + " of units left");
      }

      unitsLeft -= units;
   }

   /**
    * check whether the execution is valid
    */
   public boolean isValid() {
      return this.unitsLeft > 0 && (duration == -1 || (System.currentTimeMillis() - startDate <= duration));
   }

   @Override
   public String toString() {
      return "{CampaignExecution " + this.getCampaignId() + " " + this.touchpointId + " " + this.unitsLeft + "/" + this.units + ", "
            + (duration == -1 ? "<no time limit>" : (System.currentTimeMillis() - startDate - duration)) + "}";
   }

   public long getTouchpointId() {
      return touchpointId;
   }

   public void setTouchpointId(long touchpointId) {
      this.touchpointId = touchpointId;
   }

   public long getCampaignId() {
      return campaignId;
   }

   public void setCampaignId(long campaignId) {
      this.campaignId = campaignId;
   }

}
