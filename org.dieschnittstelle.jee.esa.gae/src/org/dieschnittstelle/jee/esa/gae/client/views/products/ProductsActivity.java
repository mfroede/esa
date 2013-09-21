package org.dieschnittstelle.jee.esa.gae.client.views.products;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProductsActivity extends
		AbstractActivityDefaultImpl<ProductsPlace> implements
		ProductsView.Presenter {

	private final ProductsView view;
	private final EventBus eventBus;

	@Inject
	public ProductsActivity(final ProductsView view,
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
