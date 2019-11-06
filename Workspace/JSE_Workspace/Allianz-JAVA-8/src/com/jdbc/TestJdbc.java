/**
 * 
 */
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.project.StudentDAO;

/**
 * @author Allianz3076
 *
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1. Load the JDBC driver

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish Connection

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Allianz?serverTimezone=UTC", "root", "");

			// 3. Create a statement

			Statement statement = connection.createStatement();

			String query = "SELECT * FROM students";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "\t" + resultSet.getInt("roll_no") + "\t"
						+ resultSet.getString("name") + "\t" + resultSet.getFloat("marks"));
			}
			
			// Insert into db using StudentDAO
			
			StudentDAO studentDao = new StudentDAO(statement, "students");
			
			studentDao.insert(21, "Shital", 34.6f);
			
			System.out.println("\n Inserted data \n");
			
			// Rerun select * to check if inserted
			
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "\t" + resultSet.getInt("roll_no") + "\t"
						+ resultSet.getString("name") + "\t" + resultSet.getFloat("marks"));
			}

			// 4. Close the sets, statements and connections
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(e.getSQLState());
			e.printStackTrace();
		}
	}

}
