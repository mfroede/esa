package org.dieschnittstelle.jee.esa.gae.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public abstract class AbstractProduct implements Serializable {

	private static final long serialVersionUID = 6940403029597060153L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "touchpoint_sequence")
	protected Long id;

	private String name;

	private int price;

	public AbstractProduct() {

	}

	public AbstractProduct(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
