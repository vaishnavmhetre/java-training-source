package com.support.base.servlet;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.support.base.context.properties.ContextProperties;
import com.support.base.context.properties.ContextPropertiesSingletonFactory;

/**
 * Servlet implementation class ContextParametersToPropertiesTranslatorService
 */
@WebServlet(loadOnStartup = 0, displayName = "Context Init Parameters To Properties Translator Servlet", urlPatterns = {
		"" })
public class ContextInitParametersToPropertiesLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContextInitParametersToPropertiesLoaderServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();

		ContextProperties properties = ContextPropertiesSingletonFactory.getInstance();
		Enumeration<String> contextInitParameterNames = getServletContext().getInitParameterNames();

		while (contextInitParameterNames.hasMoreElements()) {
			String parameterName = contextInitParameterNames.nextElement();
			properties.put(parameterName, getServletContext().getInitParameter(parameterName));
		}

		// getServletContext().setAttribute("_properties", properties);

	}
}
