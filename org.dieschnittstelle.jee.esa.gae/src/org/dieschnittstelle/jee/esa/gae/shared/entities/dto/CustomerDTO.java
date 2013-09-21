package org.dieschnittstelle.jee.esa.gae.shared.entities.dto;

public class CustomerDTO {
   private long id;
   private String gender;
   private String firstName;
   private String password;
   private String lastName;
   private String mobilePhoneId;
   private String email;
   private AddressDTO address;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getMobilePhoneId() {
      return mobilePhoneId;
   }

   public void setMobilePhoneId(String mobilePhoneId) {
      this.mobilePhoneId = mobilePhoneId;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public AddressDTO getAddress() {
      return address;
   }

   public void setAddress(AddressDTO address) {
      this.address = address;
   }

}
