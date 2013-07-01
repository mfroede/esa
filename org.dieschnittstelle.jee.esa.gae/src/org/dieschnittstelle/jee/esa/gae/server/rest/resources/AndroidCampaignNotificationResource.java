package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dieschnittstelle.jee.esa.gae.server.gcm.Datastore;

@Path("/campaignnotifications")
public class AndroidCampaignNotificationResource {

   @GET
   @Path("/register/{deviceId}")
   @Produces(MediaType.TEXT_PLAIN)
   public String registerForNotification(@PathParam("deviceId") String deviceId) {
      Datastore.register(deviceId);
      return "success";
   }
}
