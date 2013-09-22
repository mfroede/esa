package org.dieschnittstelle.jee.esa.gae.client.services;

import javax.ws.rs.POST;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface RegistrationResourceAsync extends RestService {

	@POST
	void registration(CustomerDTO customerDTO,
			MethodCallback<CustomerDTO> callback);

}