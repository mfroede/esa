package org.dieschnittstelle.jee.esa.erp.model;

import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonCreator;

@XmlType(namespace = "http://taeglichmahl.org/crm/model/data")
public enum ProductType {

	BREAD, ROLL, PASTRY;
	
	@JsonCreator
	public static ProductType deserialise(String pt) {	
		return ProductType.valueOf(ProductType.class,pt);
	}
}
