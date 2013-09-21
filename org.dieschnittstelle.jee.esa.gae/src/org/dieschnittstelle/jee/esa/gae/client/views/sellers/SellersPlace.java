package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SellersPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<SellersPlace> {

		@Override
		public SellersPlace getPlace(final String token) {
			return new SellersPlace();
		}

		@Override
		public String getToken(final SellersPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
