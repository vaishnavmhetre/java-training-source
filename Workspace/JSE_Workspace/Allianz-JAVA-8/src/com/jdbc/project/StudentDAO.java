/**
 * 
 */
package com.jdbc.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Allianz3076
 *
 */
public class StudentDAO {

	protected Connection connection;
	protected Statement statement;
	protected String tableName;

	/**
	 * @param statement
	 * @throws SQLException
	 */
	public StudentDAO(Connection connection, String tableName) throws SQLException {
		this(connection, connection.createStatement(), tableName);
	}

	/**
	 * @param statement
	 * @throws SQLException
	 */
	public StudentDAO(Statement statement, String tableName) throws SQLException {
		this(statement.getConnection(), statement, tableName);
	}

	/**
	 * @param statement
	 * @throws SQLException
	 */
	public StudentDAO(Connection connection, Statement statement, String tableName) {
		setConnection(connection);
		setStatement(statement);
		setTableName(tableName);
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public int insert(int rollNo, String name, float marks) throws SQLException {
		String query = "INSERT INTO `?` VALUES (NULL, ?, ?, ?)";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, getTableName());
		ps.setInt(2, rollNo);
		ps.setString(3, name);
		ps.setFloat(4, marks);

		return ps.executeUpdate();
	}

}
