package com.studentdb.support.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

	protected Connection connection;
	protected Statement statement;

	/**
	 * @param connection
	 * @param statement
	 * @throws SQLException 
	 */
	public DatabaseManager(Connection connection) throws SQLException {
		setConnection(connection);
		createStatment();
	}

	/**
	 * Checks if manager has a reliable connection at disposal
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean hasConnection() throws SQLException {
		return getConnection() == null && !getConnection().isClosed();
	}

	/**
	 * Checks if manager has a reliable statement at disposal
	 * 
	 * @return true if statement is neither null nor closed else false
	 * @throws SQLException
	 */
	public boolean hasStatement() throws SQLException {
		return getStatement() == null && !getStatement().isClosed();
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
	 * Creates new statement using existing connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Statement createStatment() throws SQLException {
		setStatement(getConnection().createStatement());
		return getStatement();
	}

	public void closeResources() throws SQLException {
		if (hasConnection())
			getConnection().close();
		if (hasStatement())
			getStatement().close();
	}

	@Override
	protected void finalize() throws Throwable {
		closeResources();
	}
}
