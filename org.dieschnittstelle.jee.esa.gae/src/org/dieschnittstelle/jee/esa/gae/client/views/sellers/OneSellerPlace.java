package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class OneSellerPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<OneSellerPlace> {

		@Override
		public OneSellerPlace getPlace(final String token) {
			return new OneSellerPlace();
		}

		@Override
		public String getToken(final OneSellerPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
