/**
 * 
 */
package com.support.database.model.support.model.support.builder;

import com.support.database.manager.DatabaseManager;
import com.support.database.model.support.model.util.MetaResolver;
import com.support.database.query.builder.QueryBuilder;

/**
 * @author Allianz3076
 *
 */
public class BuilderSupport<T> {

	protected Class<T> modelClass;
	protected DatabaseManager databaseManager;
	protected QueryBuilder queryBuilder;

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

	public String getTableName() {
		return MetaResolver.getTableNameForClass(getModelClass());
	}

	/**
	 * @return the customQueryBuilder
	 */
	public QueryBuilder getQueryBuilder() {
		return getOrCreateQueryBuilder();
	}

	/**
	 * @param queryBuilder the customQueryBuilder to set
	 */
	protected void setQueryBuilder(QueryBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	protected boolean hasQueryBuilder() {
		return queryBuilder != null;
	}

	protected QueryBuilder createQueryBuilder() {
		return new QueryBuilder(getDatabaseManager()).table(getTableName());
	}

	protected QueryBuilder getOrCreateQueryBuilder() {
		if (hasQueryBuilder())
			return queryBuilder;
		else {
			setQueryBuilder(createQueryBuilder());
			return queryBuilder;
		}
	}

	protected QueryBuilder getOrPushSelectToQueryBuilder() {
		return getQueryBuilder().select(new String[] {});
	}

}
