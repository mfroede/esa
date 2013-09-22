package org.dieschnittstelle.jee.esa.gae.client.services;

import java.util.List;

import javax.ws.rs.GET;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface CampaignResourceAsync extends RestService {
   // Methode ist ne get-Methode (parameter allCampaigns hat keine Parameter, )
   @GET
   void getAllCampaigns(MethodCallback<List<CampaignDTO>> callback);

}