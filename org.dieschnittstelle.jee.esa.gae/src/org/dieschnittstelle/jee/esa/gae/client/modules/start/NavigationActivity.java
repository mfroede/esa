package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.views.campaigns.CampaignsPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.LoginPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.login_registration.RegistrationPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.products.ProductsPlace;
import org.dieschnittstelle.jee.esa.gae.client.views.sellers.SellersPlace;

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
		placeController.goTo(new ProductsPlace());
	}

	@Override
	public void onMenuLoginClicked() {
		placeController.goTo(new LoginPlace());
	}

	@Override
	public void onMenuRegistrationClicked() {
		placeController.goTo(new RegistrationPlace());
	}

	@Override
	public void onMenuCampaignsClicked() {
		placeController.goTo(new CampaignsPlace());
	}

	@Override
	public void onMenuSellersClicked() {
		placeController.goTo(new SellersPlace());
	}
}
