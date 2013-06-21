package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;

@Path("/touchpoint")
public class TouchpointResource {

	private final TouchpointCRUD touchpointCRUD;

	public TouchpointResource() {
		touchpointCRUD = new TouchpointCRUDImpl();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createTouchpoint(JAXBElement<AbstractTouchpoint> touchpointDTO) {
		return "not yet implemented";
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllTouchpoints() {
		return "not yet implemented";
	}

}
