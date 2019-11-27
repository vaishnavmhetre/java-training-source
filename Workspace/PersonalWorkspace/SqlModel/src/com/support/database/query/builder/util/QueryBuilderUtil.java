/**
 * 
 */
package com.support.database.query.builder.util;

import static com.support.database.query.builder.util.flags.QueryBuilderFlags.END_DELIMITER;

import java.util.Collection;

import com.support.database.query.builder.util.flags.QueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class QueryBuilderUtil {
	public static String getQueryAppendableValue(Object value) {
		StringBuilder builder = new StringBuilder();
		if (value == null) {
			builder.append(QueryBuilderFlags.NULL);
		} else if (value instanceof String) {
			builder.append('\'');
			builder.append(value);
			builder.append('\'');
		} else if (value instanceof Collection<?>) {
			builder = appendArrayToBuilderWithParantheses(builder, (Collection<?>) value);
		} else
			builder.append(value);
		return builder.toString();
	}

	public static String getBracedName(String data) {
		StringBuilder builder = new StringBuilder();
		builder.append(QueryBuilderFlags.NAME_BRACE);
		builder.append(data);
		builder.append(QueryBuilderFlags.NAME_BRACE);
		return builder.toString();
	}

	public static StringBuilder checkAndAddEndDelimiter(StringBuilder builder) {
		if (builder.charAt(builder.length() - 1) != END_DELIMITER)
			builder.append(END_DELIMITER);

		return builder;
	}

	public static StringBuilder appendArrayToBuilder(StringBuilder queryBuilder, Collection<?> items) {
		items.forEach((item) -> queryBuilder.append(getQueryAppendableValue(item) + ","));
		queryBuilder.replace(queryBuilder.length() - 1, queryBuilder.length(), ""); // Removed trailing ',' after
																					// the data filling
		return queryBuilder;
	}

	public static StringBuilder appendBracedItemsFromArraysToBuilder(StringBuilder queryBuilder,
			Collection<String> items) {
		items.forEach((item) -> queryBuilder.append(getBracedName(item) + ","));
		queryBuilder.replace(queryBuilder.length() - 1, queryBuilder.length(), ""); // Removed trailing ',' after
																					// the data filling
		return queryBuilder;
	}

	public static StringBuilder appendArrayToBuilderWithParantheses(StringBuilder queryBuilder, Collection<?> items) {
		queryBuilder.append('(');
		queryBuilder = appendArrayToBuilder(queryBuilder, items);
		queryBuilder.append(')');
		return queryBuilder;
	}

	public static StringBuilder appendBracedItemsFromArraysToBuilderWithParantheses(StringBuilder queryBuilder,
			Collection<String> items) {
		queryBuilder.append('(');
		queryBuilder = appendBracedItemsFromArraysToBuilder(queryBuilder, items);
		queryBuilder.append(')');
		return queryBuilder;
	}
}
