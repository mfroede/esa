package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Campaign implements Serializable {

   @Id
   @XmlAttribute
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   private static final long serialVersionUID = 4407600000386810001L;

   @XmlElement
   @OneToMany(cascade = { CascadeType.ALL })
   private List<ProductBundle> bundles;

   @XmlAttribute
   private String name;
   @XmlAttribute
   private int price;
   @XmlAttribute
   private String imageUrl;

   public Campaign() {
      this.bundles = new ArrayList<ProductBundle>();
   }

   public Collection<ProductBundle> getBundles() {
      return this.bundles;
   }

   public void setBundles(List<ProductBundle> bundles) {
      this.bundles = bundles;
   }

   public void addBundle(ProductBundle bundle) {
      this.bundles.add(bundle);
   }

   @Override
   public String toString() {
      return "{Campaign " + this.getId() + ", " + getName() + ", " + this.bundles + "}";
   }

   @Override
   public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this, new String[] { "bundles" });
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String url) {
      this.imageUrl = url;
   }

}
