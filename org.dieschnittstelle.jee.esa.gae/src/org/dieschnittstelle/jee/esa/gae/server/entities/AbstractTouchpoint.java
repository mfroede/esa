package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * this is an abstraction over different touchpoints (with pos being the most
 * prominent one, others may be a service center, website, appsite, etc.)
 * 
 * @author kreutel
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@MappedSuperclass
public abstract class AbstractTouchpoint implements Serializable {

   private static final long serialVersionUID = 5207353251688141788L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   protected int erpPointOfSaleId;

   protected String name;

   @XmlTransient
   @JsonIgnore
   @ManyToMany
   private Collection<Customer> customers = new HashSet<Customer>();

   public AbstractTouchpoint() {

   }

   public abstract Long getId();

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

   public Collection<Customer> getCustomers() {
      return customers;
   }

   public void setCustomers(HashSet<Customer> customers) {
      this.customers = customers;
   }

   public void addCustomer(Customer customer) {
      this.customers.add(customer);
   }

   @Override
   public boolean equals(Object obj) {

      if (obj == null || !(obj instanceof AbstractTouchpoint)) {
         return false;
      }

      return this.getId() == ((AbstractTouchpoint) obj).getId();
   }

}
