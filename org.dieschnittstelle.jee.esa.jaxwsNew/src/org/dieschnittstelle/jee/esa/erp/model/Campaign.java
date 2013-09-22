package org.dieschnittstelle.jee.esa.erp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.HashCodeBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://dieschnittstelle.org/jee/esa/erp/model")
public class Campaign extends AbstractProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4407600000386810001L;

	private List<ProductBundle> bundles;

	public Campaign() {
		this.bundles = new ArrayList<ProductBundle>();
	}

	public Campaign(String name) {
		super(name);
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

	public String toString() {
		return "{Campaign " + this.getId() + ", " + this.getName() + ", "
				+ this.bundles + "}";
	}

//	public boolean equals(Object other) {
//		return EqualsBuilder.reflectionEquals(this, other,
//				new String[] { "bundles" })
//				&& LangUtils
//						.setequals(this.bundles, ((Campaign) other).bundles);
//	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this,
				new String[] { "bundles" });
	}

}
