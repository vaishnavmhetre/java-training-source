/**
 * 
 */
package com.support.database.model.support.model.support.builder;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.support.database.annotation.sql.Column;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.data.builder.DataBuilder;
import com.support.database.model.support.exception.ModelProcessException;
import com.support.database.model.support.model.contract.ModelSupport;
import com.support.database.model.support.model.util.MetaResolver;
import com.support.database.model.support.util.ReflectionUtility;

/**
 * @author Allianz3076
 *
 */
public class Builder<T> extends BuilderSupport<T> implements ModelSupport<T> {

	public Builder(Class<T> modelClass, DatabaseManager databaseManager) {
		setModelClass(modelClass);
		setDatabaseManager(databaseManager);
	}

	public Builder<T> select(String... columns) {
		getQueryBuilder().select(columns);
		return this;
	}

	public Builder<T> where(String column, String operator, Object value) {
		getOrPushSelectToQueryBuilder().where(column, operator, value);
		return this;
	}

	public Builder<T> where(String column, Object value) {
		getOrPushSelectToQueryBuilder().where(column, value);
		return this;
	}

	public Builder<T> whereBetween(String column, Object min, Object max) {
		getOrPushSelectToQueryBuilder().whereBetween(column, min, max);
		return this;
	}

	public Builder<T> whereIn(String column, Collection<?> values) {
		getOrPushSelectToQueryBuilder().whereIn(column, values);
		return this;
	}

	public Builder<T> whereIn(String column, Object[] values) {
		getOrPushSelectToQueryBuilder().whereIn(column, values);
		return this;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> get() throws ModelProcessException {
		try {
			ResultSet data = getQueryBuilder().get();

			return (Collection<T>) DataBuilder.buildAll(data, getModelClass(), getColumnFields());

		} catch (Exception e) {
			throw new ModelProcessException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.support.database.model.support.model.contract.ModelSupport#
	 * getColumnFields()
	 */
	@Override
	public Field[] getColumnFields() {
		return ReflectionUtility.getAnnotatedDeclaredFields(getModelClass(), Column.class, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.support.database.model.support.model.contract.ModelSupport#getColumns()
	 */
	@Override
	public Set<String> getColumns() {
		return Collections.unmodifiableSet(getColumnsWithType().keySet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.support.database.model.support.model.contract.ModelSupport#
	 * getColumnsWithType()
	 */
	@Override
	public Map<String, Class<?>> getColumnsWithType() {
		return MetaResolver.getColumnsMap(getColumnFields());
	}

}
