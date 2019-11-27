/**
 * 
 */
package com.support.database;

import java.util.Collection;

/**
 * @author Allianz3076
 *
 */
public class GeneralUtil {
	public static StringBuilder appendArrayToBuilder(StringBuilder builder, Collection<?> items) {
		items.forEach((item) -> builder.append(item + ","));
		builder.replace(builder.length() - 1, builder.length(), ""); // Removed trailing ',' after
																		// the data filling
		return builder;
	}

	public static StringBuilder appendArrayToBuilderWithParantheses(StringBuilder builder, Collection<?> items) {
		builder.append('(');
		builder = appendArrayToBuilder(builder, items);
		builder.append(')');
		return builder;
	}

}
