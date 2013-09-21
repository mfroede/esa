package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class OneSellerActivity extends
		AbstractActivityDefaultImpl<SellersPlace> implements
		OneSellerView.Presenter {

	private final OneSellerView view;
	private final EventBus eventBus;

	@Inject
	public OneSellerActivity(final OneSellerView view, final EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		view.setPresenter(this);
		panel.setWidget(view);

	}
}
