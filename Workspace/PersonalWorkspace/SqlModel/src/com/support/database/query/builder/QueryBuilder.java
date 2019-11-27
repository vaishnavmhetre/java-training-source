/**
 * 
 */
package com.support.database.query.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import com.support.database.manager.DatabaseManager;
import com.support.database.query.builder.util.QueryBuilderUtil;
import com.support.database.query.builder.util.flags.QueryBuilderFlags;
import com.support.database.query.support.QueryBetweenCondition;
import com.support.database.query.support.QueryCondition;

/**
 * @author Allianz3076
 *
 */
public class QueryBuilder {

	protected String tableName;
	protected StringBuilder queryBuilder;

	protected DatabaseManager databaseManager;

	protected boolean conditionAlreadyStarted = false;

	public QueryBuilder(DatabaseManager databaseManager) {
		setQueryBuilder(new StringBuilder());
		setDatabaseManager(databaseManager);
	}

	protected QueryBuilder() {
		setQueryBuilder(new StringBuilder());
	}

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

	public QueryBuilder table(String tableName) {
		this.setTableName(tableName);
		return this;
	}

	public QueryBuilder select(String... columns) {
		queryBuilder.append("SELECT ");

		if (columns != null && columns.length > 0) {
			queryBuilder = QueryBuilderUtil.appendBracedItemsFromArraysToBuilder(queryBuilder, Arrays.asList(columns));
		} else
			queryBuilder.append(" * ");

		queryBuilder.append(" FROM " + QueryBuilderUtil.getBracedName(getTableName()) + " ");

		return this;
	}

	public QueryBuilder limit(int limit) {
		queryBuilder.append(" LIMIT " + limit);

		return this;
	}

	public ResultSet first() throws SQLException {
		return limit(1).get();
	}

	public ResultSet get() throws SQLException {

		queryBuilder = QueryBuilderUtil.checkAndAddEndDelimiter(queryBuilder);

		String query = queryBuilder.toString();

		return getDatabaseManager().getStatement().executeQuery(query);
	}

	public ResultSet get(int recordCount) throws SQLException {
		return limit(recordCount).get();
	}

	protected QueryBuilder checkAndAppendWhereIfConditionNotStarted() {
		if (!conditionAlreadyStarted) {
			queryBuilder.append(" WHERE ");
			conditionAlreadyStarted = true;
		}

		return this;
	}

	public QueryBuilder where(String column, String operator, Object value) {
		checkAndAppendWhereIfConditionNotStarted();

		queryBuilder.append(new QueryCondition(column, operator, value).getSqlString());

		return this;
	}

	public QueryBuilder where(String column, Object value) {
		return where(column, QueryBuilderFlags.CONDITION_EQUAL, value);
	}

	public QueryBuilder whereBetween(String column, Object min, Object max) {
		checkAndAppendWhereIfConditionNotStarted();

		queryBuilder.append(new QueryBetweenCondition(column, min, max).getSqlString());

		return this;
	}

	public QueryBuilder whereIn(String column, Collection<?> values) {
		return where(column, QueryBuilderFlags.CONDITION_IN, values);
	}

	public QueryBuilder whereIn(String column, Object[] values) {
		return where(column, QueryBuilderFlags.CONDITION_IN, Arrays.asList(values));
	}

	public QueryBuilder and() {
		queryBuilder.append(" " + new QueryCondition(QueryBuilderFlags.CONDITION_JOINER_AND) + " ");

		return this;
	}

	public QueryBuilder or() {
		queryBuilder.append(" " + new QueryCondition(QueryBuilderFlags.CONDITION_JOINER_OR) + " ");

		return this;
	}
}
