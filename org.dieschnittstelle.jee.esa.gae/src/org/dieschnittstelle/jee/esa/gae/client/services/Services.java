package org.dieschnittstelle.jee.esa.gae.client.services;

import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;

public class Services {
	private static final String BASE_URL = "http://127.0.0.1:8888/rest";
	private static LoginResourceAsync loginResourceAsync;
	private static CampaignResourceAsync campaignResourceAsync;
	private static RegistrationResourceAsync registrationResourceAsync;

	public static final LoginResourceAsync login() {
		if (loginResourceAsync == null) {
			loginResourceAsync = GWT.create(LoginResourceAsync.class);
			((RestServiceProxy) loginResourceAsync).setResource(new Resource(
					BASE_URL + "/login"));
		}
		return loginResourceAsync;
	}

	public static final RegistrationResourceAsync registration() {
		if (registrationResourceAsync == null) {
			registrationResourceAsync = GWT
					.create(RegistrationResourceAsync.class);
			((RestServiceProxy) registrationResourceAsync)
					.setResource(new Resource(BASE_URL + "/customer"));
		}
		return registrationResourceAsync;
	}

	public static final CampaignResourceAsync campaigns() {
		if (campaignResourceAsync == null) {
			campaignResourceAsync = GWT.create(CampaignResourceAsync.class);
			((RestServiceProxy) campaignResourceAsync)
					.setResource(new Resource(BASE_URL + "/campaign"));
		}
		return campaignResourceAsync;
	}
}
