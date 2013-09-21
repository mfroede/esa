package org.dieschnittstelle.jee.esa.servlets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.model.AbstractTouchpoint;

public class TouchpointWebServiceServlet extends HttpServlet {

	protected static Logger logger = Logger
			.getLogger(TouchpointWebServiceServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("doGet()");

		// we assume here that GET will only be used to return the list of all
		// touchpoints

		// obtain the executor for reading out the touchpoints
		TouchpointCRUDExecutor exec = (TouchpointCRUDExecutor) getServletContext()
				.getAttribute("touchpointCRUD");
		String pathInfo = request.getPathInfo();
		try {
			// set the status
			response.setStatus(HttpServletResponse.SC_OK);
			// obtain the output stream from the response and write the list of
			// touchpoints into the stream
			ObjectOutputStream oos = new ObjectOutputStream(
					response.getOutputStream());
			// write the object
			oos.writeObject(exec.readAllTouchpoints());
			oos.close();
		} catch (Exception e) {
			String err = "got exception: " + e;
			logger.error(err, e);
			throw new RuntimeException(e);
		}

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// obtain the executor for reading out the touchpoints
      TouchpointCRUDExecutor exec = (TouchpointCRUDExecutor) getServletContext()
            .getAttribute("touchpointCRUD");
      String pathInfo = req.getPathInfo();
      if(exec.deleteTouchpoint(Integer.parseInt(pathInfo.substring(pathInfo.lastIndexOf("/")+1)))) {
         resp.setStatus(HttpServletResponse.SC_OK);
      } else {
         resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
      }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	      TouchpointCRUDExecutor exec = (TouchpointCRUDExecutor) getServletContext()
	              .getAttribute("touchpointCRUD");
	      ServletInputStream stream = req.getInputStream();  
	      ObjectInputStream objStream = new ObjectInputStream(stream);
	      try {
			AbstractTouchpoint tp = (AbstractTouchpoint) objStream.readObject();
			exec.createTouchpoint(tp);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
