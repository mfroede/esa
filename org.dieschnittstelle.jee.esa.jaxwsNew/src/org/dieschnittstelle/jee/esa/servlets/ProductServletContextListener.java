package org.dieschnittstelle.jee.esa.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jboss.logging.Logger;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProductServletContextListener implements ServletContextListener {

	protected static Logger logger = Logger
			.getLogger(ProductServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		logger.info("contextDestroyed()");

		// we read out the TouchpointCRUDExecutor and let it store its content
		ProductCRUDExecutor exec = (ProductCRUDExecutor) evt
				.getServletContext().getAttribute("ProductCRUD");

		logger.info("contextDestroyed(): loaded executor from context: " + exec);

		if (exec == null) {
			logger.warn("contextDestroyed(): no executor found in context. Ignore.");
		} 
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {

		logger.info("contextInitialised()");
		ProductCRUDExecutor exec = new ProductCRUDExecutor();

		// then we put the executor into the context to make it available to the
		// other components
		evt.getServletContext().setAttribute("ProductCRUD", exec);
	}

}
