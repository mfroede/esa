package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoginView extends IsWidget {

	public interface Presenter {
		void onButtonClick(String name, String password);
	}

	void setPresenter(Presenter presenter);

}
