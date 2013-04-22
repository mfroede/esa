package org.dieschnittstelle.jee.esa.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TouchpointWebServiceServletFilter implements Filter {

	protected static Logger logger = Logger
			.getLogger(TouchpointWebServiceServletFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// check whether we have an accept header that allows text/html,
		// otherwise reject the request
		String acceptHeader = ((HttpServletRequest) request)
				.getHeader("accept");
		String servletPath = ((HttpServletRequest) request)
				.getServletPath();
		logger.info("got acceptHeader: " + acceptHeader);

		// we do quite a brute force string match
		if (acceptHeader != null && acceptHeader.contains("text/html") && servletPath != null && servletPath.contains("/service/touchpoints")) {
			// if we do not find the required header, we block access
			((HttpServletResponse) response)
			.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			chain.doFilter(request, response);
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
