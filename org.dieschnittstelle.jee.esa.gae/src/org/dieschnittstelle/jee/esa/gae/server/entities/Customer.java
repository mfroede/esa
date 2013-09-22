package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Customer implements Serializable {

   protected static Logger logger = Logger.getLogger(Customer.class.getName());

   private static final long serialVersionUID = 7461272049473919251L;

   @Id
   @XmlElement
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   public Long getId() {
      return id;
   }

   private String gender;

   private String firstName;
   private String password;

   private String lastName;

   private String mobilePhoneId;

   private String email;

   @ManyToOne(cascade = { CascadeType.ALL })
   private Address address;

   public Customer() {
      logger.info("<constructor>");
   }

   public Customer(String firstName, String lastName, String gender) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
   }

   public Customer(String firstName, String lastName, String gender, String mobilePhoneId) {
      this(firstName, lastName, gender);
      this.mobilePhoneId = mobilePhoneId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
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

   public void setMobilePhoneId(String mobilePhoneID) {
      this.mobilePhoneId = mobilePhoneID;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   @Override
   public String toString() {
      return "{Customer " + this.id + " " + this.firstName + " " + this.lastName + " (" + this.gender + ") " + this.email + ", " + this.mobilePhoneId + ", " + this.address + "}";
   }

   public void setGender(String gd) {
      this.gender = gd;
   }

   public String getGender() {
      return this.gender;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
