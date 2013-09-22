package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.NavigationPlace;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.campaigns.CampaignsPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.campaigns.OneCampaignPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.sellers.OneSellerPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.sellers.SellersPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ StartPlace.Tokenizer.class, LoginPlace.Tokenizer.class,
		NavigationPlace.Tokenizer.class, RegistrationPlace.Tokenizer.class,
		ProductsPlace.Tokenizer.class, OneProductPlace.Tokenizer.class,
		SellersPlace.Tokenizer.class, OneSellerPlace.Tokenizer.class,
		CampaignsPlace.Tokenizer.class, OneCampaignPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
