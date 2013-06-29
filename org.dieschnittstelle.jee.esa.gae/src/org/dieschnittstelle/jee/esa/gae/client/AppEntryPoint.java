package org.dieschnittstelle.jee.esa.gae.client;

import org.dieschnittstelle.jee.esa.gae.client.common.AppPlaceHistoryMapper;
import org.dieschnittstelle.jee.esa.gae.client.gin.AppGinjector;
import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class AppEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {

		AppGinjector injector = GWT.create(AppGinjector.class);
		EventBus eventBus = injector.getEventBus();

		ActivityMapper activityMapper = injector.getActivityMapper();

		SimplePanel content = new SimplePanel();
		ActivityManager contentActivityManager = new ActivityManager(
				activityMapper, eventBus);
		contentActivityManager.setDisplay(content);

		RootPanel.get().add(content);

		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(injector.getPlaceController(), eventBus,
				new StartPlace());

		historyHandler.handleCurrentHistory();
	}
}
