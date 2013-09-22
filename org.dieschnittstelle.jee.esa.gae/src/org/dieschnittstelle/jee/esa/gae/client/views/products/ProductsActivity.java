package org.dieschnittstelle.jee.esa.gae.client.views.products;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignExecutionDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProductsActivity extends
		AbstractActivityDefaultImpl<ProductsPlace> implements
		ProductsView.Presenter {

	private final ProductsView view;
	private final EventBus eventBus;

	@Inject
	public ProductsActivity(final ProductsView view, final EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		Services.campaignExecutions().getAllCampaignExecutions(
				new MethodCallback<List<CampaignExecutionDTO>>() {

					@Override
					public void onSuccess(Method method,
							List<CampaignExecutionDTO> response) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub

					}
				});
		view.setPresenter(this);
		panel.setWidget(view);

	}
}
