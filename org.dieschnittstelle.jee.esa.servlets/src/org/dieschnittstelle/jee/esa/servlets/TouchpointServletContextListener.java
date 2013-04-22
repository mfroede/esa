package org.dieschnittstelle.jee.esa.servlets;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class TouchpointServletContextListener implements ServletContextListener {

	protected static Logger logger = Logger
			.getLogger(TouchpointServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		logger.info("contextDestroyed()");

		// we read out the TouchpointCRUDExecutor and let it store its content
		TouchpointCRUDExecutor exec = (TouchpointCRUDExecutor) evt
				.getServletContext().getAttribute("touchpointCRUD");

		logger.info("contextDestroyed(): loaded executor from context: " + exec);

		if (exec == null) {
			logger.warn("contextDestroyed(): no executor found in context. Ignore.");
		} else {
			exec.store();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {

		logger.info("contextInitialised()");

		// we create a new executor for a file to be stored in the context root
		String rootPath = evt.getServletContext().getRealPath("/");
		TouchpointCRUDExecutor exec = new TouchpointCRUDExecutor(new File(
				rootPath, "touchpoints.data"));

		// we call load() on the executor to load any exsisting data (if there
		// are any)
		exec.load();

		// then we put the executor into the context to make it available to the
		// other components
		evt.getServletContext().setAttribute("touchpointCRUD", exec);
	}

}
