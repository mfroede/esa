package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignExecutionCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignExecutionCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;
import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Datastore;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Message;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Sender;

@Path("/campaign")
public class CampaignResource {

   private static final String NEW_CAMPAIGN_INFO = "new campaign";
   private static final String INFO = "info";
   private static final Logger LOGGER = Logger.getLogger(CampaignResource.class.getName());
   private final Sender sender;

   private final CampaignCRUD campaignCRUD;
   private final CampaignExecutionCRUD campaignExecutionCRUD;

   public CampaignResource() {
      sender = new Sender("AIzaSyDgOHQwpaSa78DgcVky3odHawkY994UNe0");
      campaignCRUD = new CampaignCRUDImpl();
      campaignExecutionCRUD = new CampaignExecutionCRUDImpl();
   }

   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Campaign createCampaign(JAXBElement<Campaign> campaignDTO) {
      return campaignCRUD.createCampaign(campaignDTO.getValue());
   }

   @POST
   @Path("/execute")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public CampaignExecution executeCampaign(JAXBElement<CampaignExecution> campaignExecutionDTO) {
      CampaignExecution cpe = campaignExecutionCRUD.createCampaignExecution(campaignExecutionDTO.getValue());
      notifyRegisteredDevices();
      return cpe;
   }

   private void notifyRegisteredDevices() {
      try {
         sender.send(new Message.Builder().addData(INFO, NEW_CAMPAIGN_INFO).build(), Datastore.getDevices(), 5);
      } catch (IOException e) {
         LOGGER.severe(e.getMessage());
      }

   }
}
