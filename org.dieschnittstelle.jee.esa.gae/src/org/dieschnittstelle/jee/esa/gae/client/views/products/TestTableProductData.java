package org.dieschnittstelle.jee.esa.gae.client.views.products;

import java.util.ArrayList;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.gae.server.entities.IndividualizedProductItem;

public class TestTableProductData {

	private final ArrayList<AbstractProduct> list;

	public TestTableProductData() {
		list = new ArrayList<AbstractProduct>();
		for (int i = 0; i <= 3; i++) {
			IndividualizedProductItem ap1 = new IndividualizedProductItem();
			// ap1.setId(i);
			ap1.setName("product" + i);
			ap1.setPrice(i);
			list.add(ap1);
		}
	}

	public ArrayList<AbstractProduct> getList() {
		return list;
	}

}
