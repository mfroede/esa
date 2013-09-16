package org.dieschnittstelle.jee.esa.gae.client.gin;

import javax.inject.Singleton;

import org.dieschnittstelle.jee.esa.gae.client.common.ActivityMapperImpl;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartActivity;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartView;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartViewImpl;

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
	}
}
