package com.allianz.shopping.support.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager {

	protected Properties properties;
	protected Connection connection;
	protected Statement statement;

	/**
	 * @param connection
	 * @param statement
	 * @throws SQLException
	 */
	public DatabaseManager(Connection connection) throws SQLException {
		setConnection(connection);
		createStatement();
	}

	/**
	 * @param properties Servlet Context for configuration access
	 * @throws SQLException
	 */
	public DatabaseManager(Properties properties) throws ClassNotFoundException, SQLException {
		setProperties(properties);
		setConnection(createConnection());
	}

	/**
	 * Creates new connection from Configuration through ServletContext (ctx)
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(getProperties().getProperty("db.driver"));
		return DriverManager.getConnection(getProperties().getProperty("db.url"),
				getProperties().getProperty("db.username"), getProperties().getProperty("db.password"));
	}

	/**
	 * Manual handle for closing of resources
	 * 
	 * @throws SQLException
	 */
	public void closeResources() throws SQLException {
		if (hasConnection())
			getConnection().close();
		if (hasStatement())
			getStatement().close();
	}

	/**
	 * Creates new statement using existing connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Statement createStatement() throws SQLException {
		setStatement(getConnection().createStatement());
		return getStatement();
	}

	@Override
	protected void finalize() throws Throwable {
		closeResources();
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
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
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setProperties(Properties propertiesp) {
		this.properties = propertiesp;
	}

	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
