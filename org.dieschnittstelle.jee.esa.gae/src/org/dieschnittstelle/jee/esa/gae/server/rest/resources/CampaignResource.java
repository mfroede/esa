package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignExecutionDTO;

import com.google.gson.Gson;

@Path("/campaign")
public class CampaignResource {

   private static final String CAMPAIGN_EXECUTION = "campaignExecution";
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

   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Campaign getCampaignById(@PathParam("id") String id) {
      return campaignCRUD.readCampaign(Long.valueOf(id));
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<CampaignDTO> getAllCampaigns() {
      List<Campaign> readAllCampaigns = campaignCRUD.readAllCampaigns();
      List<CampaignDTO> result = new LinkedList<>();
      for (Campaign campaign : readAllCampaigns) {
         result.add(DtoTransformer.instance().toCampaignDTO(campaign));
      }
      return result;
   }

   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Campaign createCampaign(JAXBElement<Campaign> campaignDTO) {
      return campaignCRUD.createCampaign(campaignDTO.getValue());
   }

   @DELETE
   @Path("/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Campaign deleteCampaign(@PathParam("id") String id) {
      Campaign c = campaignCRUD.readCampaign(Long.valueOf(id));
      if (c != null) {
         campaignCRUD.deleteCampaign(c.getId());
      }
      return c;
   }

   @POST
   @Path("/executions")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public CampaignExecutionDTO executeCampaign(JAXBElement<CampaignExecution> campaignExecutionDTO) {
      CampaignExecution cpe = campaignExecutionCRUD.createCampaignExecution(campaignExecutionDTO.getValue());
      notifyRegisteredDevices(cpe);
      return DtoTransformer.instance().toCampaignExecutionDTO(cpe);
   }

   @GET
   @Path("/executions")
   @Produces(MediaType.APPLICATION_JSON)
   public List<CampaignExecutionDTO> getAllExecutions() {
      List<CampaignExecution> allCampaignExecutions = campaignExecutionCRUD.readAllCampaignExecutions();
      List<CampaignExecutionDTO> result = new LinkedList<>();

      for (CampaignExecution campaignExecution : allCampaignExecutions) {
         result.add(DtoTransformer.instance().toCampaignExecutionDTO(campaignExecution));
      }
      return result;
   }

   private void notifyRegisteredDevices(CampaignExecution cpe) {
      try {
         // @formatter:off
         CampaignExecutionDTO campaignExecutionDTO = DtoTransformer.instance().toCampaignExecutionDTO(cpe);
         Message msg = new Message.Builder()
            .addData(INFO, NEW_CAMPAIGN_INFO)
            .addData(CAMPAIGN_EXECUTION, new Gson().toJson(campaignExecutionDTO))
            .build();
         // @formatter:on
         sender.send(msg, Datastore.getDevices(), 5);
      } catch (IOException e) {
         LOGGER.severe(e.getMessage());
      }
   }
}
