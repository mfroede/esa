package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class OneCampaignPlace extends Place {
	public static class Tokenizer implements
			PlaceTokenizer<OneCampaignPlace> {

		@Override
		public OneCampaignPlace getPlace(final String token) {
			return new OneCampaignPlace();
		}

		@Override
		public String getToken(final OneCampaignPlace place) {
			return ""; //$NON-NLS-1$
		}

	}
}
