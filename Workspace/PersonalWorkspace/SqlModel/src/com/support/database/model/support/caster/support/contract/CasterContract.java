/**
 * 
 */
package com.support.database.model.support.caster.support.contract;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Allianz3076
 *
 */
public interface CasterContract<T>{
	public T cast(ResultSet rs, String column) throws SQLException;
}
