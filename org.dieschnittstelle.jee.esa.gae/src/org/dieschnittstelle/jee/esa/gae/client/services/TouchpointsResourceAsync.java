package org.dieschnittstelle.jee.esa.gae.client.services;

import java.util.List;

import javax.ws.rs.GET;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.TouchpointDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface TouchpointsResourceAsync extends RestService {
	// Methode ist ne get-Methode (parameter allCampaigns hat keine Parameter, )
	@GET
	void getAllTouchpoints(MethodCallback<List<TouchpointDTO>> callback);

}