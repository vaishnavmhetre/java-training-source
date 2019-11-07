package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentdb.support.dao.StudentDAO;
import com.studentdb.support.database.DatabaseManager;

/**
 * Servlet implementation class StudentDbServlet
 */
@WebServlet("/StudentDbServlet")
public class StudentDbServlet extends HttpServlet {
	protected StudentDAO stduentDao;

	public StudentDAO getStduentDao() {
		return stduentDao;
	}

	public void setStduentDao(StudentDAO stduentDao) {
		this.stduentDao = stduentDao;
	}

	private static final long serialVersionUID = 1L;

	protected static Connection getNewConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Allianz?serverTimezone=UTC", "root", "");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDbServlet() {
		super();
		try {
			setStduentDao(new StudentDAO(new DatabaseManager(getNewConnection()), "students"));
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html><html><head><title></title></head><body>"
				+ "<style>table {border-collapse: collapse;}table, td, th {border: 1px solid black;}</style>"
				+ "<table>");

		String studentRowViewFormat = "<td>%d</td><td>%d</td><td>%s</td><td>%f</td>";
		String studentRowHeadViewFormat = "<th>%s</th>";

		try {
			ResultSet studentDetails = getStduentDao().getAll();
			ResultSetMetaData rsmd = studentDetails.getMetaData();

			out.println("<tr>");
			for (int iter = 1; iter <= rsmd.getColumnCount(); iter++)
				out.print(String.format(studentRowHeadViewFormat, rsmd.getColumnName(iter)));
			out.println("<tr>");

			while (studentDetails.next()) {
				out.println("<tr>");
				out.println(String.format(studentRowViewFormat, studentDetails.getInt("id"),
						studentDetails.getInt("roll_no"), studentDetails.getString("name"),
						studentDetails.getFloat("marks")));
				out.println("</tr>");
			}

			out.println("</table>");
			studentDetails.close();
			getStduentDao().getDbManager().closeResources();
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
			e.printStackTrace();
			out.println("Failed to get student details");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
