package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.StationaryTouchpoint;

@Path("/touchpoint")
public class TouchpointResource {

   private final TouchpointCRUD touchpointCRUD;

   public TouchpointResource() {
      touchpointCRUD = new TouchpointCRUDImpl();
   }

   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public AbstractTouchpoint getTouchpointById(@PathParam("id") String id) {
      return touchpointCRUD.readTouchpoint(Long.valueOf(id));
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<AbstractTouchpoint> getAllTouchpoints() {
      return touchpointCRUD.readAllTouchpoints();
   }

   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public AbstractTouchpoint createTouchpoint(JAXBElement<StationaryTouchpoint> touchpointDTO) {
      return touchpointCRUD.createTouchpoint(touchpointDTO.getValue());
   }

   @DELETE
   @Path("/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public AbstractTouchpoint deleteCampaign(@PathParam("id") String id) {
      AbstractTouchpoint touchpoint = touchpointCRUD.readTouchpoint(Long.valueOf(id));
      if (touchpoint != null) {
         touchpointCRUD.deleteTouchpoint(touchpoint.getId());
      }
      return touchpoint;
   }

}
