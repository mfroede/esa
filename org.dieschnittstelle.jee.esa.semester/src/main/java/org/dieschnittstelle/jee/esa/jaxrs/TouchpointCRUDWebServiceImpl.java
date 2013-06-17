package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;

public class TouchpointCRUDWebServiceImpl implements ITouchpointCRUDWebService {

   /**
    * this accessor will be provided by the ServletContext, to which it is
    * written by the TouchpointServletContextListener
    */
   // private final TouchpointCRUDStateless touchpointCRUD;

   /**
    * here we will be passed the context parameters by the resteasy framework
    * note that the request context is only declared for illustration purposes,
    * but will not be further used here
    * 
    * @param servletContext
    */
   public TouchpointCRUDWebServiceImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
   }

   @Override
   public List<StationaryTouchpoint> readAllTouchpoints() {
      return null;
   }

   @Override
   public StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint) {
      return null;
   }

   @Override
   public boolean deleteTouchpoint(int id) {
      return false;
   }

}
