package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;
import org.dieschnittstelle.jee.esa.gae.server.entities.IndividualizedProductItem;
import org.dieschnittstelle.jee.esa.gae.server.entities.ProductBundle;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Datastore;

@Path("/campaignnotifications")
public class AndroidCampaignNotificationResource {

   @GET
   @Path("/register/{deviceId}")
   @Produces(MediaType.TEXT_PLAIN)
   public String registerForNotification(@PathParam("deviceId") String deviceId) {
      Datastore.register(deviceId);

      // TODO

      Campaign c = new Campaign();
      List<ProductBundle> bundles = new ArrayList<>();
      ProductBundle bundle = new ProductBundle();
      bundle.setId(0);
      IndividualizedProductItem ip = new IndividualizedProductItem();
      ip.setName("Coffee");
      ip.setPrice(50);
      ip.setId(0);
      bundle.setProduct(ip);
      bundles.add(bundle);
      c.setBundles(bundles);
      c.setName("Coffee Campaign");

      return "success";
   }
}
