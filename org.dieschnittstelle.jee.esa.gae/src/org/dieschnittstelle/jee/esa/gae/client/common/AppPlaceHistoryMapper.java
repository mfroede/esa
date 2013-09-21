package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.NavigationPlace;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ StartPlace.Tokenizer.class, LoginPlace.Tokenizer.class,
		NavigationPlace.Tokenizer.class, RegistrationPlace.Tokenizer.class,
		ProductsPlace.Tokenizer.class, OneProductPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
