package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class LoginActivity extends AbstractActivityDefaultImpl<LoginPlace>
		implements LoginView.Presenter {

	private final LoginView view;
	private final EventBus eventBus;

	@Inject
	public LoginActivity(final LoginView view, final EventBus eventBus) {
		this.view = view;
		this.eventBus = eventBus;

	}

	@Override
	public void start(final AcceptsOneWidget panel,
			final com.google.gwt.event.shared.EventBus pEventBus) {
		view.setPresenter(this);

		panel.setWidget(view);

	}

	@Override
	public void onButtonClick(String name, String password) {
		LoginDTO loginDTO = new LoginDTO();

		loginDTO.setUserName(name);
		loginDTO.setPassword(password);

		Services.login().login(loginDTO, new MethodCallback<CustomerDTO>() {

			@Override
			public void onSuccess(Method method, CustomerDTO response) {
				// TODO login success
				System.out.println("");
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO login failed
				System.out.println("");
				Window.alert("Name oder Passwort falsch");
			}
		});
	}
}
