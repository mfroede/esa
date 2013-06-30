package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dieschnittstelle.jee.esa.gae.server.gcm.Datastore;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Message;
import org.dieschnittstelle.jee.esa.gae.server.gcm.MulticastResult;
import org.dieschnittstelle.jee.esa.gae.server.gcm.Sender;

@Path("/campaignnotifications")
public class AndroidCampaignNotificationResource {

	private final Sender sender;

	public AndroidCampaignNotificationResource() {
		sender = new Sender("AIzaSyDgOHQwpaSa78DgcVky3odHawkY994UNe0");
	}

	@GET
	@Path("/register/{deviceId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String registerForNotification(@PathParam("deviceId") String deviceId) {
		Datastore.register(deviceId);
		return "success";
	}

	@POST
	@Path("/send")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendMessage(String message) {
		try {
			MulticastResult send = sender.send(
					new Message.Builder().addData("message", message).build(),
					Datastore.getDevices(), 1);
			return "success:" + send.getSuccess();
		} catch (IOException e) {
			return e.getMessage();
		}

	}
}
