package org.dieschnittstelle.jee.esa.gae.client.services;

import javax.ws.rs.POST;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface LoginResourceAsync extends RestService {

   @POST
   void login(LoginDTO loginDTO, MethodCallback<CustomerDTO> callback);

}