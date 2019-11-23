/**
 * 
 */
package com.support.database.model;

import java.sql.ResultSet;
import java.util.Collection;

import com.support.database.model.data.builder.DataBuilder;
import com.support.database.model.support.exception.ModelProcessException;
import com.support.database.model.support.model.ModelSupport;
import com.support.database.query.builder.QueryBuilder;

/**
 * @author Allianz3076
 *
 */
public class Model<T> extends ModelSupport<T> {

	public Model(Class<T> modelClass) {
		super(modelClass);
	}

	@SuppressWarnings("unchecked")
	public Collection<T> all(Collection<String> columns) throws ModelProcessException {

		try {
			ResultSet data = new QueryBuilder(getDatabaseManager()).table(getTableName()).select(columns).get();

			return (Collection<T>) DataBuilder.buildAll(data, modelClass, getColumnFields());

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}

	}
}
