package org.dieschnittstelle.jee.esa.erp.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/*
 * Ü3: entfernen Sie die Auskommentierung der Annotation
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class AbstractProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6940403029597060153L;

	private int id;

	private String name;

	public AbstractProduct() {

	}

	public AbstractProduct(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
