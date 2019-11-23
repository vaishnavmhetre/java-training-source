/**
 * 
 */
package com.support.database.model.support.caster.support.implicit.casts;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.support.database.model.support.caster.support.contract.supportabstract.Caster;

/**
 * @author Allianz3076
 *
 */
public class LongCaster extends Caster<Long> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.support.database.query.builder.support.caster.support.contract.
	 * CasterContract#cast(java.sql.ResultSet)
	 */
	@Override
	public Long cast(ResultSet rs, String column) throws SQLException {
		return rs.getLong(column);
	}

}
