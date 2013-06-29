package org.dieschnittstelle.jee.esa.gae.client.gin;

import org.dieschnittstelle.jee.esa.gae.client.common.ActivityMapperImpl;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(ProductionGinModule.class)
public interface AppGinjector extends Ginjector {

	public EventBus getEventBus();

	public PlaceController getPlaceController();

	public ActivityMapperImpl getActivityMapper();

}
