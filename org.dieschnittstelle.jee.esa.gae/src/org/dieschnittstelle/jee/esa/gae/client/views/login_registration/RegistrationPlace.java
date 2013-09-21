package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegistrationPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<RegistrationPlace> {

		@Override
		public RegistrationPlace getPlace(final String token) {
			return new RegistrationPlace();
		}

		@Override
		public String getToken(final RegistrationPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
