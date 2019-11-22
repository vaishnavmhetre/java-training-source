package com.allianz.shopping.controller.autostartup;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.allianz.shopping.data.dao.db.UserDAO;
import com.allianz.shopping.data.model.User;

/**
 * Servlet Filter implementation class AutoLoadAuthenticatedUser
 */
@WebFilter("/*")
public class AutoLoadAuthenticatedUser implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoadAuthenticatedUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getSession() != null) {
			if (httpServletRequest.getSession().getAttribute("auth") != null) {
				int userId = (int) httpServletRequest.getSession().getAttribute("auth");
				User user;
				try {
					user = new UserDAO().findUserById(userId);
					if (user != null) {
						httpServletRequest.setAttribute("authenticatedUser", user);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
		chain.doFilter(httpServletRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
