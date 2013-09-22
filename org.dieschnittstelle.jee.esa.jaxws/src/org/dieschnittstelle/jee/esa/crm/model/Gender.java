package org.dieschnittstelle.jee.esa.crm.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * see issue: http://jira.codehaus.org/browse/JACKSON-193
 * @author kreutel
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(namespace = "http://dieschnittstelle.org/jee/esa/crm/model")
public enum Gender {
	
	M, W;
				
}