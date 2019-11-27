/**
 * 
 */
package com.support.database.model;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Collection;

import com.support.database.manager.DatabaseManager;
import com.support.database.model.data.builder.DataBuilder;
import com.support.database.model.support.exception.ModelProcessException;
import com.support.database.model.support.model.contract.ModelSupport;
import com.support.database.model.support.model.support.builder.Builder;
import com.support.database.model.support.model.util.MetaResolver;

/**
 * @author Allianz3076
 *
 */
public class Model<T> extends Builder<T> implements ModelSupport<T> {

	public Model(Class<T> modelClass, DatabaseManager databaseManager) {
		super(modelClass, databaseManager);
	}

	@SuppressWarnings("unchecked")
	public Collection<T> all(String... columns) throws ModelProcessException {

		try {
			ResultSet data = getQueryBuilder().select(columns).get();

			return (Collection<T>) DataBuilder.buildAll(data, getModelClass(), getColumnFields());

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}

	}

	public Collection<T> all() throws ModelProcessException {
		return this.all(new String[] {});
	}

	@SuppressWarnings("unchecked")
	public T first(String... columns) throws ModelProcessException {
		try {
			ResultSet data = getQueryBuilder().select(columns).first();

			if (!data.first())
				return null;

			return (T) DataBuilder.build(data, getModelClass(), getColumnFields());
		} catch (Exception e) {
			throw new ModelProcessException(e);
		}
	}

	public T first() throws ModelProcessException {
		return this.first(new String[] {});
	}

	@SuppressWarnings("unchecked")
	public T find(Object id) throws ModelProcessException {
		try {
			Field idField = MetaResolver.forceGetIdFieldForModel(getModelClass());

			ResultSet data = getQueryBuilder().select(new String[] {}).where(idField.getName(), id).first();

			if (!data.first())
				return null;

			return (T) DataBuilder.build(data, getModelClass(), getColumnFields());

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll(Object id) throws ModelProcessException {
		try {
			Field idField = MetaResolver.forceGetIdFieldForModel(getModelClass());

			ResultSet data = getQueryBuilder().select(new String[] {}).where(idField.getName(), id).get();

			return (Collection<T>) DataBuilder.buildAll(data, getModelClass(), getColumnFields());

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}
	}

}
