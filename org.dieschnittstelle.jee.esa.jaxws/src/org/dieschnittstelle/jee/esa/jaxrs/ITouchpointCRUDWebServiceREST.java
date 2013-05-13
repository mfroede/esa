package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.List;

import org.dieschnittstelle.jee.esa.crm.model.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/touchpoints")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface ITouchpointCRUDWebServiceREST {
	
	@GET
	public List<StationaryTouchpoint> readAllTouchpoints();
	
	@POST
	public StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint); 
	
	@DELETE
	@Path("/{touchpointId}")
	public boolean deleteTouchpoint(@PathParam("touchpointId") int id); 
		
	/*
	 * Ü1: add a new annotated method for using the updateTouchpoint functionality of TouchpointCRUDExecutor and implement it
	 */
	
}
