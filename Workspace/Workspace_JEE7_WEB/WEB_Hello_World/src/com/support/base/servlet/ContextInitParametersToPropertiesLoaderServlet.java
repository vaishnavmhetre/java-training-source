package com.support.base.servlet;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		Enumeration<String> contextInitParameterNames = getServletContext().getInitParameterNames();
		ContextProperties properties = ContextPropertiesSingletonFactory.getInstance();

		while (contextInitParameterNames.hasMoreElements()) {
			String parameterName = contextInitParameterNames.nextElement();
			properties.put(parameterName, getServletContext().getInitParameter(parameterName));
		}

		// getServletContext().setAttribute("_properties", properties);

	}
}
