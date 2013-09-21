package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartActivity;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginActivity;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationActivity;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductActivity;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsActivity;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ActivityMapperImpl implements ActivityMapper {

	@Inject
	Provider<StartActivity> startActivityProvider;
	@Inject
	Provider<LoginActivity> loginActivityProvider;
	@Inject
	Provider<RegistrationActivity> registrationActivityProvider;
	@Inject
	Provider<ProductsActivity> productsActivityProvider;
	@Inject
	Provider<OneProductActivity> oneProductActivityProvider;

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof StartPlace) {
			return startActivityProvider.get();
		}
		if (place instanceof LoginPlace) {
			return loginActivityProvider.get();
		}
		if (place instanceof RegistrationPlace) {
			return registrationActivityProvider.get();
		}
		if (place instanceof ProductsPlace) {
			return productsActivityProvider.get();
		}
		if (place instanceof OneProductPlace) {
			return oneProductActivityProvider.get();
		}
		return null;
	}

}
