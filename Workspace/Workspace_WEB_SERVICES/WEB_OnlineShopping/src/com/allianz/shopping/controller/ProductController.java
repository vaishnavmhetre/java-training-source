package com.allianz.shopping.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.data.dao.contract.ProductDAO;
import com.allianz.shopping.data.dao.db.ProductDAODbImpl;
import com.allianz.shopping.data.model.Product;
import com.allianz.shopping.util.DateUtility;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	ProductDAO productDAO = new ProductDAOImpl();
	ProductDAO productDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			productDAO = new ProductDAODbImpl();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ServletException("Unable to create ProductDao Instance", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null) {

			if (action.equalsIgnoreCase("delete")) {

				Product product = new Product();
				product.setId(Integer.parseInt(request.getParameter("id")));
				productDAO.delete(product);

				response.sendRedirect("ProductController");
				return;

			} else if (action.equalsIgnoreCase("edit")) {

				Product product = productDAO.find(Integer.parseInt(request.getParameter("id")));

				if (product != null) {
					request.setAttribute("product", product);
					RequestDispatcher dispatcher = request.getRequestDispatcher("updateProduct.jsp");

					if (dispatcher != null)
						dispatcher.forward(request, response);

					return;
				}

				response.sendRedirect("ProductController");
				return;
			}

		}
		List<Product> products = productDAO.getAll();
		products.forEach((product) -> {
			product.setCategories(productDAO.getCategoriesOfProduct(product));
		});
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");

		if (dispatcher != null)
			dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equalsIgnoreCase("update")) {
				try {
					Product product = new Product(request.getParameter("name"), request.getParameter("description"),
							Float.parseFloat(request.getParameter("price")),
							DateUtility.convertStringToDate(request.getParameter("manufactureDate")));

					productDAO.update(product, Integer.parseInt(request.getParameter("id")));

				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
			} else if (action.equals("add")) {
				try {

					Product product = new Product(request.getParameter("name"), request.getParameter("description"),
							Float.parseFloat(request.getParameter("price")),
							DateUtility.convertStringToDate(request.getParameter("manufactureDate")));

					productDAO.add(product);

				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
			}
		}

		response.sendRedirect("ProductController");
		return;
	}

}
