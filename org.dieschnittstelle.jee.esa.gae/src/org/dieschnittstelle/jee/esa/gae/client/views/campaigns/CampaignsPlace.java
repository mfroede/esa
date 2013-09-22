package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CampaignsPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<CampaignsPlace> {

		@Override
		public CampaignsPlace getPlace(final String token) {
			return new CampaignsPlace();
		}

		@Override
		public String getToken(final CampaignsPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
