/**
 * 
 */
package com.support.database.query.builder.util;

import static com.support.database.query.builder.util.flags.QueryBuilderFlags.END_DELIMITER;

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
			builder.append('"');
			builder.append(value);
			builder.append('"');
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
		if(builder.charAt(builder.length()-1) != END_DELIMITER)
			builder.append(END_DELIMITER);
		
		return builder;
	}
}
