package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

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

import org.dieschnittstelle.jee.esa.gae.server.crud.CustomerCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CustomerCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;

@Path("/customer")
public class CustomerResource {

	private final CustomerCRUD customerCRUD;

	public CustomerResource() {
		customerCRUD = new CustomerCRUDImpl();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer createCustomer(JAXBElement<Customer> customerDTO) {
		return customerCRUD.createCustomer(customerDTO.getValue());
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") String id) {
		return customerCRUD.readCustomer(Integer.parseInt(id));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer updateCustomer(JAXBElement<Customer> customerDTO) {
		return customerCRUD.updateCustomer(customerDTO.getValue());
	}

	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String id) {
		if (customerCRUD.deleteCustomer(Integer.parseInt(id))) {
			return "success";
		}
		return "no such customer";
	}
}
