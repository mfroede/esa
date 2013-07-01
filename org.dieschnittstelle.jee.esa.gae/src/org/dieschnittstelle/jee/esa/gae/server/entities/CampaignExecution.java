package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * the execution of a campaign for some erpCampaignId, some touchpoint, some
 * quantity of units, some start date and some duration
 */
@XmlRootElement
public class CampaignExecution implements Serializable {

   private static final long serialVersionUID = 5077516349500947392L;

   private AbstractTouchpoint touchpoint;

   private int erpCampaignId;

   public void setTouchpoint(AbstractTouchpoint touchpoint) {
      this.touchpoint = touchpoint;
   }

   public void setErpCampaignId(int erpCampaignId) {
      this.erpCampaignId = erpCampaignId;
   }

   public void setUnits(int units) {
      this.units = units;
   }

   public void setDuration(long duration) {
      this.duration = duration;
   }

   private int units;

   private final long startDate = System.currentTimeMillis();

   private long duration;

   public AbstractTouchpoint getTouchpoint() {
      return touchpoint;
   }

   public int getErpCampaignId() {
      return erpCampaignId;
   }

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
         throw new RuntimeException("campaign for " + erpCampaignId + " has expired!");
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
      return "{CampaignExecution " + this.erpCampaignId + " " + this.touchpoint + " " + this.unitsLeft + "/" + this.units + ", "
            + (duration == -1 ? "<no time limit>" : (System.currentTimeMillis() - startDate - duration)) + "}";
   }

}
