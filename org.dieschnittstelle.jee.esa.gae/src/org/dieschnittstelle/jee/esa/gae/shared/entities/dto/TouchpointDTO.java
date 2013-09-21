package org.dieschnittstelle.jee.esa.gae.shared.entities.dto;

public class TouchpointDTO {

   private Long id;

   protected int erpPointOfSaleId;

   protected String name;

   private AddressDTO address;

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

   public AddressDTO getAddress() {
      return address;
   }

   public void setAddress(AddressDTO address) {
      this.address = address;
   }

}
