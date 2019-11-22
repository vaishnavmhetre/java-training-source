/**
 * 
 */
package com.support.database.query.builder;

import static com.support.database.query.builder.util.QueryBuilderUtil.checkAndAddEndDelimiter;
import static com.support.database.query.builder.util.QueryBuilderUtil.getBracedName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.support.database.manager.DatabaseManager;

/**
 * @author Allianz3076
 *
 */
public class QueryBuilder {

	protected String tableName;
	protected StringBuilder queryBuilder;

	protected DatabaseManager databaseManager;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the queryBuilder
	 */
	public StringBuilder getQueryBuilder() {
		return queryBuilder;
	}

	/**
	 * @param queryBuilder the queryBuilder to set
	 */
	public void setQueryBuilder(StringBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	/**
	 * @return the databaseManager
	 */
	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	/**
	 * @param databaseManager the databaseManager to set
	 */
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public static QueryBuilder table(String tableName) {
		QueryBuilder builder = new QueryBuilder();
		builder.setTableName(tableName);
		return builder;
	}

	public QueryBuilder select() {
		return select(null);
	}

	public QueryBuilder select(List<String> columns) {
		queryBuilder.append("SELECT ");

		if (columns != null) {
			columns.forEach((column) -> queryBuilder.append(getBracedName(column) + ","));
			queryBuilder.replace(queryBuilder.length() - 1, queryBuilder.length(), ""); // Removed trailing ',' after
																						// the data filling
		} else
			queryBuilder.append(" * ");

		queryBuilder.append(" FROM " + getBracedName(getTableName()) + " ");

		return this;
	}

	public QueryBuilder limit(int limit) {
		queryBuilder.append(" LIMIT " + limit);

		return this;
	}

	public ResultSet get() throws SQLException {

		checkAndAddEndDelimiter(queryBuilder);

		String query = queryBuilder.toString();

		return getDatabaseManager().getStatement().executeQuery(query);
	}

}
