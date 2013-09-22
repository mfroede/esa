package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class OneCampaignActivity extends
		AbstractActivityDefaultImpl<OneCampaignPlace> implements
		OneCampaignView.Presenter {

	private final OneCampaignView view;
	private final EventBus eventBus;

	@Inject
	public OneCampaignActivity(final OneCampaignView view,
			final EventBus eventBus) {
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
