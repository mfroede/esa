package org.dieschnittstelle.jee.esa.gae.client.views.products;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProductsPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<ProductsPlace> {

		@Override
		public ProductsPlace getPlace(final String token) {
			return new ProductsPlace();
		}

		@Override
		public String getToken(final ProductsPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
