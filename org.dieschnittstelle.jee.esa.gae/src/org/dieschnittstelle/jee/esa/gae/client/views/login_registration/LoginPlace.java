package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<LoginPlace> {

		@Override
		public LoginPlace getPlace(final String token) {
			return new LoginPlace();
		}

		@Override
		public String getToken(final LoginPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
