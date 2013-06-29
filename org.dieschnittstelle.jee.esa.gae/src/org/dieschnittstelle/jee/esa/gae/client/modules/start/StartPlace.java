/*******************************************************************************
 * Qyotta UG (haftungsbeschränkt) (http://www.qyotta.de).
 * All rights reserved.
 * Copyright (c) 2012 Qyotta UG
 *******************************************************************************/
package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StartPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<StartPlace> {

		@Override
		public StartPlace getPlace(final String token) {
			return new StartPlace();
		}

		@Override
		public String getToken(final StartPlace place) {
			return ""; //$NON-NLS-1$
		}

	}

}
