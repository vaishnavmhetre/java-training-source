/**
 * 
 */
package com.support.database.model.support.sql.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author Allianz3076
 *
 */
public class MetaResolver {

	public static boolean resultSetDataHasColumn(ResultSet rs, String column) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

		for (int iter = 1; iter <= metaData.getColumnCount(); iter++)
			if (metaData.getColumnName(iter).equals(column))
				return true;

		return false;
	}
}
