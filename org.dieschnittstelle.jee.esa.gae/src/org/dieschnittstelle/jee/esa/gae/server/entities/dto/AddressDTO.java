package org.dieschnittstelle.jee.esa.gae.server.entities.dto;

public class AddressDTO extends LocationDTO {

   private String street;

   private String houseNr;

   private String zipCode;

   private String city;

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getHouseNr() {
      return houseNr;
   }

   public void setHouseNr(String houseNr) {
      this.houseNr = houseNr;
   }

   public String getZipCode() {
      return zipCode;
   }

   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

}
