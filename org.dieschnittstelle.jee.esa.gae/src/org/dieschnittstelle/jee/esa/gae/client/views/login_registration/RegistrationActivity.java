package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.AddressDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class RegistrationActivity extends
		AbstractActivityDefaultImpl<RegistrationPlace> implements
		RegistrationView.Presenter {

	private final RegistrationView view;
	private final EventBus eventBus;

	@Inject
	public RegistrationActivity(final RegistrationView view,
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

	@Override
	public void onButtonClick(String firstName, String lastName, String gender,
			String city, String street, String houseNr, String email,
			String phoneID, String password) {
		CustomerDTO customer = new CustomerDTO();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setGender(gender);

		customer.setEmail(email);
		customer.setMobilePhoneId(phoneID);
		customer.setPassword(password);
		AddressDTO address = new AddressDTO();
		address.setCity(city);
		address.setStreet(street);
		address.setHouseNr(houseNr);
		customer.setAddress(address);

		Services.registration().registration(customer,
				new MethodCallback<CustomerDTO>() {

					@Override
					public void onSuccess(Method method, CustomerDTO response) {
						// TODO login success
						Window.alert("Sie wurden erfolgreich im System registriert");
					}

					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO login failed
						Window.alert("Bitte Überprüfen sie ihre Angaben. Leider konnten wir sie nicht registrieren.");
					}
				});
	}
}
