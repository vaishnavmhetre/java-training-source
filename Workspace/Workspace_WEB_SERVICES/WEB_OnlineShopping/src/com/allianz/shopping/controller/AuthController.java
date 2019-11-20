package com.allianz.shopping.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.data.dao.db.UserDAO;
import com.allianz.shopping.data.model.User;
import com.allianz.shopping.support.auth.AuthenticationManager;
import com.allianz.shopping.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

	UserDAO userDao;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			userDao = new UserDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException("Unable to create UserDao instance", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {

			if (action.equalsIgnoreCase("register")) {
				User user = new User();

				user.setName(request.getParameter("name"));
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));

				int status = userDao.createUser(user);

				if (status > 0) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("register.jsp");
				}
			} else if (action.equalsIgnoreCase("login")) {
				try {
					User user = AuthenticationManager.login(request.getParameter("username"), request.getParameter("password"));
					if(user != null) {
						request.getSession(true).setAttribute("auth", user.getId());
						response.sendRedirect("ProductController");
					} 
				} catch (ClassNotFoundException | SQLException | InvalidQueryBuilderParameter e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("login.jsp");
			}
		}
	}

}
