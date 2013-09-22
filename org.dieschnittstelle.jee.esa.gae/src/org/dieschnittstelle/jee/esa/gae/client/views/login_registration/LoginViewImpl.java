package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class LoginViewImpl extends AbstractView implements LoginView {

	@UiField
	TextBox name;

	@UiField
	PasswordTextBox password;

	private static LoginViewImplUiBinder uiBinder = GWT
			.create(LoginViewImplUiBinder.class);

	interface LoginViewImplUiBinder extends UiBinder<Widget, LoginViewImpl> {
		// TODO Generated by GWT
	}

	private Presenter presenter;

	@Inject
	public LoginViewImpl() {
		content.add(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler({ "button" })
	void onButtonPressed(ClickEvent e) {
		presenter.onButtonClick(name.getText(), password.getText());
	}
}
