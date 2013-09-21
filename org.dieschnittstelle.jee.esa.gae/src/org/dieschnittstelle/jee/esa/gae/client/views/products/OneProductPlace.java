package org.dieschnittstelle.jee.esa.gae.client.views.products;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class OneProductPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<OneProductPlace> {

		@Override
		public OneProductPlace getPlace(final String token) {
			return new OneProductPlace();
		}

		@Override
		public String getToken(final OneProductPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
