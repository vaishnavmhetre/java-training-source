/**
 * 
 */
package com.support.database.model.support.caster.support;

import java.sql.ResultSet;

import com.support.database.model.support.exception.ModelProcessException;

/**
 * @author Allianz3076
 *
 */
public class ValueCaster {

	@SuppressWarnings("unchecked")
	public static <T> T cast(Class<?> modelClass, ResultSet rs, String column, Class<?> typeClass)
			throws ModelProcessException {
		Class<?> caster = MetaResolver.getCasterForType(modelClass, typeClass);

		try {
			return (T) caster.getMethod("cast", ResultSet.class, String.class).invoke(caster.newInstance(), rs, column);
		} catch (Exception e) {
			throw new ModelProcessException(e);
		}

	}
}
