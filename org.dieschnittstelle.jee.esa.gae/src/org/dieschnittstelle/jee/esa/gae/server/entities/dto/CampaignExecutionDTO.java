package org.dieschnittstelle.jee.esa.gae.server.entities.dto;

public class CampaignExecutionDTO {

   private Long id;

   private TouchpointDTO touchpoint;

   private CampaignDTO campaign;

   private int units;

   private final long startDate = System.currentTimeMillis();

   private long duration;

   private int unitsLeft;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public TouchpointDTO getTouchpoint() {
      return touchpoint;
   }

   public void setTouchpoint(TouchpointDTO touchpoint) {
      this.touchpoint = touchpoint;
   }

   public CampaignDTO getCampaign() {
      return campaign;
   }

   public void setCampaign(CampaignDTO campaign) {
      this.campaign = campaign;
   }

   public int getUnits() {
      return units;
   }

   public void setUnits(int units) {
      this.units = units;
   }

   public long getDuration() {
      return duration;
   }

   public void setDuration(long duration) {
      this.duration = duration;
   }

   public int getUnitsLeft() {
      return unitsLeft;
   }

   public void setUnitsLeft(int unitsLeft) {
      this.unitsLeft = unitsLeft;
   }

   public long getStartDate() {
      return startDate;
   }

}
