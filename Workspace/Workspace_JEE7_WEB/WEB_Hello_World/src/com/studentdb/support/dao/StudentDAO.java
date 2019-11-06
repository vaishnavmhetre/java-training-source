/**
 * 
 */
package com.studentdb.support.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import com.studentdb.support.database.DatabaseManager;
import com.studentdb.support.querybuilder.SqlQueryBuilder;
import com.studentdb.support.querybuilder.exceptions.InvalidQueryBuilderParameter;

/**
 * DAO for Student db
 * 
 * @author Allianz3076
 *
 */
public class StudentDAO {

	protected DatabaseManager dbManager;
	protected String tableName;

	/**
	 * @param statement
	 * @throws SQLException
	 */
	public StudentDAO(DatabaseManager dbManager, String tableName) {
		setDbManager(dbManager);
		setTableName(tableName);
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return getDbManager().getConnection();
	}

	/**
	 * @return the dbManager
	 */
	public DatabaseManager getDbManager() {
		return dbManager;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return getDbManager().getStatement();
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * Inserts new Student in db Specialized to accept the custom PK id
	 * 
	 * @param id
	 * @param rollNo
	 * @param name
	 * @param marks
	 * @return
	 * @throws SQLException
	 *             Escalates SQL level exceptions
	 * @throws InvalidQueryBuilderParameter
	 *             When no data (null) is passed to insert as values
	 */
	public int insert(int id, int rollNo, String name, float marks) throws SQLException, InvalidQueryBuilderParameter {
		/*
		 * String query = "INSERT INTO `?` VALUES (?, ?, ?, ?)"; PreparedStatement ps =
		 * getConnection().prepareStatement(query); ps.setString(1, getTableName());
		 * ps.setInt(2, id); ps.setInt(3, rollNo); ps.setString(4, name); ps.setFloat(5,
		 * marks); int status = ps.executeUpdate(); ps.close(); return status;
		 */

		List<String> columns = Arrays.asList("id", "roll_no", "name", "marks");

		List<Object> values = Arrays.asList(id, rollNo, name, marks);

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getStatement().executeUpdate(query);

	}

	/**
	 * Inserts new Student in db Specialized to refrain from accepting the PK id
	 * 
	 * @param rollNo
	 * @param name
	 * @param marks
	 * @return
	 * @throws SQLException
	 * @throws InvalidQueryBuilderParameter
	 */
	public int insert(int rollNo, String name, float marks) throws SQLException, InvalidQueryBuilderParameter {
		/*
		 * String query = "INSERT INTO `?` VALUES (NULL, ?, ?, ?)"; PreparedStatement ps
		 * = getConnection().prepareStatement(query); ps.setString(1, getTableName());
		 * ps.setInt(2, rollNo); ps.setString(3, name); ps.setFloat(4, marks); int
		 * status = ps.executeUpdate(); ps.close(); return status;
		 */

		List<String> columns = Arrays.asList("roll_no", "name", "marks");

		List<Object> values = Arrays.asList(rollNo, name, marks);

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getStatement().executeUpdate(query);
	}
	
	public ResultSet getAll() throws SQLException {
		List<String> columns = Arrays.asList("id", "roll_no", "name", "marks");
		String query = new SqlQueryBuilder(getTableName()).select(columns);
		return getStatement().executeQuery(query);
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		getDbManager().setConnection(connection);
	}

	/**
	 * @param dbManager
	 *            the dbManager to set
	 */
	public void setDbManager(DatabaseManager dbManager) {
		this.dbManager = dbManager;
	}

	/**
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(Statement statement) {
		getDbManager().setStatement(statement);
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
