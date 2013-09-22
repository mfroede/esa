package org.dieschnittstelle.jee.esa.gae.client.services;

import java.util.List;

import javax.ws.rs.GET;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignExecutionDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface CampaignExecutionResourceAsync extends RestService {
	// Methode ist ne get-Methode (parameter allCampaigns hat keine Parameter, )
	@GET
	void getAllCampaignExecutions(
			MethodCallback<List<CampaignExecutionDTO>> callback);

}