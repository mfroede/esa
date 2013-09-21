package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class StartViewImpl extends AbstractView implements StartView {

	private static StartViewImplUiBinder uiBinder = GWT
			.create(StartViewImplUiBinder.class);

	interface StartViewImplUiBinder extends UiBinder<Widget, StartViewImpl> {
		// TODO Generated by GWT
	}

	private Presenter presenter;

	@Inject
	public StartViewImpl() {
		content.add(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("button")
	void onButtonPressed(ClickEvent e) {
		presenter.onButtonClick();
	}
}
