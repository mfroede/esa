package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.TouchpointDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SellersActivity extends AbstractActivityDefaultImpl<SellersPlace>
		implements SellersView.Presenter {

	private final SellersView view;
	private final EventBus eventBus;

	@Inject
	public SellersActivity(final SellersView view, final EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		Services.touchpoints().getAllTouchpoints(
				new MethodCallback<List<TouchpointDTO>>() {

					@Override
					public void onFailure(Method method, Throwable exception) {
						System.out.println("");

					}

					@Override
					public void onSuccess(Method method,
							List<TouchpointDTO> response) {
						System.out.println();
						view.setTouchpoints(response);

					}
				});
		view.setPresenter(this);
		panel.setWidget(view);

	}
}
