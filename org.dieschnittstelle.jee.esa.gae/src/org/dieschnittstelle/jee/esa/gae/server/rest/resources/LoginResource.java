package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.dieschnittstelle.jee.esa.gae.server.crud.CustomerCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CustomerCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;

@Path("/login")
public class LoginResource {

   private final CustomerCRUD customerCRUD;

   public LoginResource() {
      customerCRUD = new CustomerCRUDImpl();
   }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public CustomerDTO login(JAXBElement<LoginDTO> jaxBElloginDTO) {
      LoginDTO loginDTO = jaxBElloginDTO.getValue();
      List<Customer> readAllCustomers = customerCRUD.readAllCustomers();
      for (Customer customer : readAllCustomers) {
         if (customer.getEmail().equals(loginDTO.getName())) {
            if (customer.getPassword().equals(loginDTO.getPassword())) {
               return DtoTransformer.instance().toCustomerDTO(customer);
            }
         }
      }
      throw new IllegalArgumentException("no such user");
   }
}
