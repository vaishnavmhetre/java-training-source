/**
 * 
 */
package com.servlet.auth.support.querybuilder;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.servlet.auth.support.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.servlet.auth.support.querybuilder.sql.support.SqlQueryCondition;
import com.servlet.auth.support.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * SQL QueryBuilder class
 * 
 * @author Allianz3076
 *
 */
public class SqlQueryBuilder {

	protected String tableName;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName - The tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @param tableName
	 */
	public SqlQueryBuilder(String tableName) {
		setTableName(tableName);
	}

	public static String getBracedName(String data) {
		StringBuilder builder = new StringBuilder();
		builder.append(SqlQueryBuilderFlags.NAME_BRACE);
		builder.append(data);
		builder.append(SqlQueryBuilderFlags.NAME_BRACE);
		return builder.toString();
	}

	/**
	 * Generates insert query for SQL.
	 * 
	 * @param values  - Values to be inserted in query
	 * @param columns - Columns in sequence to mention in query
	 * @return SQL query built from values and columns
	 * @throws InvalidQueryBuilderParameter Throws exception if values are not
	 *                                      provided to the query builder
	 */
	public String insert(List<Object> values, List<String> columns) throws InvalidQueryBuilderParameter {

		StringBuilder builder = new StringBuilder("INSERT INTO ");

		builder.append(getBracedName(getTableName()));

		if (columns != null) {
			builder.append('(');
			columns.forEach((column) -> builder.append(getBracedName(column) + ","));
			builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after the data filling
			builder.append(')');
		}

		builder.append(" ");
		if (values != null) {
			builder.append("VALUES (");
			values.forEach((value) -> builder.append(getQueryAppendableValue(value) + ","));
			builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after the data filling
			builder.append(')');
		} else {
			throw new InvalidQueryBuilderParameter("Values are expected for the query");
		}

		builder.append(';');

		return builder.toString();
	}

	/**
	 * Generates insert query for SQL. <br>
	 * <b>Note: </b>Here the sequence of values comply as of SQL Table Schema
	 * 
	 * @param values - Values to be inserted in query
	 * @return SQL query built from values (only)
	 * @throws InvalidQueryBuilderParameter Throws exception if values are not
	 *                                      provided to the query builder
	 */
	public String insert(List<Object> values) throws InvalidQueryBuilderParameter {
		return insert(values, null);
	}

	/**
	 * Generates update query for SQL.
	 * 
	 * @param values
	 *            - Values to be inserted in query
	 * @param columns
	 *            - Columns in sequence to mention in query
	 * @return SQL query built from values and columns
	 * @throws InvalidQueryBuilderParameter
	 *             Throws exception if values are not provided to the query builder
	 */
	public String update(Map<String, Object> values, List<SqlQueryCondition> conditions)
			throws InvalidQueryBuilderParameter {

		StringBuilder builder = new StringBuilder("UPDATE ");

		builder.append(getBracedName(getTableName()));

		if (values != null) {
			builder.append("SET ");
			Set<String> keys = values.keySet();

			for (String key : keys)
				builder.append(key + "=" + getQueryAppendableValue(values.get(key)) + ',');

			builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after the data filling

		} else {
			throw new InvalidQueryBuilderParameter("Values are expected for the query");
		}

		if (conditions != null) {
			builder.append("WHERE ");
			for (SqlQueryCondition condition : conditions)
				builder.append(" " + condition.getSqlString());
		}
		else
			throw new InvalidQueryBuilderParameter("Conditions are expected for the query");

		builder.append(';');

		return builder.toString();
	}

	public String select(List<String> columns, List<SqlQueryCondition> conditions) {
		StringBuilder builder = new StringBuilder("SELECT ");
		if (columns != null) {
			columns.forEach((column) -> builder.append(getBracedName(column) + ","));
			builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after the data filling
		} else
			builder.append("*");

		builder.append(" FROM " + getBracedName(getTableName()));

		if (conditions != null) {
			builder.append(" WHERE ");
			for (SqlQueryCondition condition : conditions)
				builder.append(" " + condition.getSqlString());
		}
		
		builder.append(';');

		return builder.toString();
	}
	
	public String select_limited(List<String> columns, List<SqlQueryCondition> conditions, int limit) {
		StringBuilder builder = new StringBuilder("SELECT ");
		if (columns != null) {
			columns.forEach((column) -> builder.append(getBracedName(column) + ","));
			builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after the data filling
		} else
			builder.append("*");

		builder.append(" FROM " + getBracedName(getTableName()));

		if (conditions != null) {
			builder.append(" WHERE ");
			for (SqlQueryCondition condition : conditions)
				builder.append(" " + condition.getSqlString());
		}
		
		builder.append(" LIMIT ");
		builder.append(limit);
		
		builder.append(';');

		return builder.toString();
	}
	
	public String select(List<String> columns) {
		return select(columns, null);
	}
	
	public String delete(List<SqlQueryCondition> conditions) {
		StringBuilder builder = new StringBuilder("DELETE ");
		
		builder.append("FROM " + getBracedName(getTableName()));

		if (conditions != null) {
			builder.append(" WHERE ");
			for (SqlQueryCondition condition : conditions)
				builder.append(" " + condition.getSqlString());
		}
		

		builder.append(';');

		return builder.toString();
	}

	/**
	 * Returns SQL representable form of data to push in query
	 * 
	 * @param value - Dirty value which can't directly be pushed
	 * @return Fresh value which can be recognized and accepted by SQL for its type
	 */
	public static String getQueryAppendableValue(Object value) {
		StringBuilder builder = new StringBuilder();
		if (value == null) {
			builder.append(SqlQueryBuilderFlags.NULL);
		} else if (value instanceof String) {
			builder.append('"');
			builder.append(value);
			builder.append('"');
		} else
			builder.append(value);
		return builder.toString();
	}
}
