package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartActivity;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ActivityMapperImpl implements ActivityMapper {

	@Inject
	Provider<StartActivity> startActivityProvider;

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof StartPlace) {
			return startActivityProvider.get();
		}
		return null;
	}

}
