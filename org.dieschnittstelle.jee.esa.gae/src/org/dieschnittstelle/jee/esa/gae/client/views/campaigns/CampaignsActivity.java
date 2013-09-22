package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CampaignsActivity extends
		AbstractActivityDefaultImpl<CampaignsPlace> implements
		CampaignsView.Presenter {

	private final CampaignsView view;
	private final EventBus eventBus;

	@Inject
	public CampaignsActivity(final CampaignsView view, final EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		Services.campaigns().getAllCampaigns(
				new MethodCallback<List<CampaignDTO>>() {

					@Override
					public void onFailure(Method method, Throwable exception) {
						System.out.println("");

					}

					@Override
					public void onSuccess(Method method,
							List<CampaignDTO> response) {
						System.out.println();
						view.setCampaigns(response);

					}
				});
		view.setPresenter(this);

		panel.setWidget(view);

	}
}
