package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.NavigationActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class NavigationViewActivityMapper implements ActivityMapper {

	
	@Inject
	Provider<NavigationActivity> navigationActivityProvider;
	
	@Override
	public Activity getActivity(Place place) {
		return navigationActivityProvider.get();
	}

}
