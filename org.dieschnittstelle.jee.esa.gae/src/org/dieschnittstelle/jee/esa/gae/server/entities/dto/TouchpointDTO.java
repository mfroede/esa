package org.dieschnittstelle.jee.esa.gae.server.entities.dto;

public class TouchpointDTO {

   private Long id;

   protected int erpPointOfSaleId;

   protected String name;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getErpPointOfSaleId() {
      return erpPointOfSaleId;
   }

   public void setErpPointOfSaleId(int erpPointOfSaleId) {
      this.erpPointOfSaleId = erpPointOfSaleId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
