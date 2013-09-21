package org.dieschnittstelle.jee.esa.gae.client.gin;

import javax.inject.Singleton;

import org.dieschnittstelle.jee.esa.gae.client.common.ActivityMapperImpl;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.NavigationView;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.NavigationViewImpl;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartActivity;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartView;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartViewImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginView;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginViewImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationView;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationViewImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductView;
import org.dieschnittstelle.jee.esa.gae.client.views.products.OneProductViewImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsView;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ProductionGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class)
				.in(Singleton.class);
		bind(ActivityMapperImpl.class).in(Singleton.class);

		bind(StartActivity.class);
		bind(StartView.class).to(StartViewImpl.class).in(Singleton.class);
		bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
		bind(NavigationView.class).to(NavigationViewImpl.class).in(
				Singleton.class);
		bind(RegistrationView.class).to(RegistrationViewImpl.class).in(
				Singleton.class);
		bind(ProductsView.class).to(ProductsViewImpl.class).in(Singleton.class);
		bind(OneProductView.class).to(OneProductViewImpl.class).in(
				Singleton.class);
	}
}
