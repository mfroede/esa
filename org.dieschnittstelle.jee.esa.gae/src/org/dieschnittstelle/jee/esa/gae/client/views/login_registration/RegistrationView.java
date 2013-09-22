package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.AddressDTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegistrationView extends IsWidget {

	public interface Presenter {
		void onButtonClick(String firstName, String lastName, String gender,
				String city, String street, String houseNr, String email,
				String phoneID, String password);
	}

	void setPresenter(Presenter presenter);

}
