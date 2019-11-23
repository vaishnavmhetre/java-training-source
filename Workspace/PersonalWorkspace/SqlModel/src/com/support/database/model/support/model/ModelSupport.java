/**
 * 
 */
package com.support.database.model.support.model;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.support.database.annotation.sql.Column;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.data.builder.DataBuilder;
import com.support.database.model.support.model.util.MetaResolver;
import com.support.database.model.support.util.ReflectionUtility;

/**
 * @author Allianz3076
 *
 */
public class ModelSupport<T> extends DataBuilder{

	protected Class<T> modelClass;
	protected DatabaseManager databaseManager;

	public ModelSupport(Class<T> modelClass) {
		setModelClass(modelClass);
	}

	/**
	 * @return the modeClass
	 */
	public Class<T> getModelClass() {
		return this.modelClass;
	}

	/**
	 * @param modelClass the modelClass to set
	 */
	protected void setModelClass(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * @return the databaseManager
	 */
	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	/**
	 * @param databaseManager the databaseManager to set
	 */
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public Field[] getColumnFields() {
		return ReflectionUtility.getAnnotatedDeclaredFields(getModelClass(), Column.class, false);
	}

	public String getTableName() {
		return MetaResolver.getTableNameForClass(getModelClass());
	}

	public Set<String> getColumns() {
		return Collections.unmodifiableSet(getColumnsWithType().keySet());
	}

	public Map<String, Class<?>> getColumnsWithType() {
		return MetaResolver.getColumnsMap(getColumnFields());
	}

}
