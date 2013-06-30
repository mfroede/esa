package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class StartActivity extends AbstractActivityDefaultImpl<StartPlace>
		implements StartView.Presenter {

	private final EventBus eventBus;
	private final StartView view;

	@Inject
	public StartActivity(final StartView view, EventBus eventBus) {
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
