package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.Address;
import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;
import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;
import org.dieschnittstelle.jee.esa.gae.server.entities.IndividualizedProductItem;
import org.dieschnittstelle.jee.esa.gae.server.entities.ProductBundle;
import org.dieschnittstelle.jee.esa.gae.server.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Datastore;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Message;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Sender;

import com.google.gson.Gson;

@Path("/campaign")
public class CampaignResource {

   private static final Logger LOGGER = Logger.getLogger(CampaignResource.class.getName());

   private final Sender sender;

   private final CampaignCRUD campaignCRUD;

   public CampaignResource() {
      sender = new Sender("AIzaSyDgOHQwpaSa78DgcVky3odHawkY994UNe0");
      campaignCRUD = new CampaignCRUDImpl();
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
      return campaignExecutionDTO.getValue();
   }

   @GET
   @Path("test2")
   @Produces(MediaType.APPLICATION_JSON)
   public Campaign getCampaign() {
      Campaign c = new Campaign();
      ProductBundle pb = new ProductBundle();
      IndividualizedProductItem product = new IndividualizedProductItem();
      product.setName("Coffee");
      product.setPrice(50);

      pb.setProduct(product);
      pb.setUnits(3564655);

      List<ProductBundle> bundles = new ArrayList<>();
      bundles.add(pb);
      c.setBundles(bundles);
      c.setName("Coffee Campaign");
      c.setPrice(50000);
      return c;
   }

   @GET
   @Path("test")
   @Produces(MediaType.APPLICATION_JSON)
   public CampaignExecution getCampaignEx() {

      StationaryTouchpoint st = new StationaryTouchpoint();
      Address location = new Address();
      location.setCity("Berlin");
      location.setHouseNr("19");
      location.setStreet("Street");
      location.setId(0);
      location.setZipCode("17863");
      location.setGeoLat(52.572842);
      location.setGeoLong(13.405131);
      st.setLocation(location);
      st.setErpPointOfSaleId(0);
      st.setName("CoffeeShop");
      CampaignExecution ce = new CampaignExecution();
      ce.setTouchpoint(st);
      ce.setDuration(2000000);
      ce.setUnits(100);
      ce.setErpCampaignId(0);
      return ce;
   }

   private void notifyRegisteredDevices(Campaign value) {
      try {
         sender.send(new Message.Builder().addData("campaign", new Gson().toJson(value)).build(), Datastore.getDevices(), 5);
      } catch (IOException e) {
         LOGGER.severe(e.getMessage());
      }

   }
}
