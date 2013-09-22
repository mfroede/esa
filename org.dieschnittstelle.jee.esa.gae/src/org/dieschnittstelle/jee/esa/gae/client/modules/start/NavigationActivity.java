package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.campaigns.CampaignsPlace;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class NavigationActivity extends
		AbstractActivityDefaultImpl<NavigationPlace> implements
		NavigationView.Presenter {

	private final NavigationView view;
	private final EventBus eventBus;
	private final PlaceController placeController;

	@Inject
	public NavigationActivity(final NavigationView view,
			final EventBus eventBus, PlaceController placeController) {
		this.view = view;
		this.eventBus = eventBus;
		this.placeController = placeController;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

	}

	@Override
	public void onMenuProductsClicked() {
		placeController.goTo(new CampaignsPlace());
	}
}
