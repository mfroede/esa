package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class NavigationPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<NavigationPlace> {

		@Override
		public NavigationPlace getPlace(final String token) {
			return new NavigationPlace();
		}

		@Override
		public String getToken(final NavigationPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
