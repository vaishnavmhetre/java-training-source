package com.allianz.shopping.data.dao.db.support;

import java.sql.SQLException;
import java.util.Properties;

import com.allianz.shopping.support.database.manager.DatabaseManager;
import com.allianz.shopping.support.database.manager.factory.DatabaseManagerSingletonFactory;

public abstract class DBDao {

	protected Properties properties;
	protected DatabaseManager databaseManager;
	protected String tableName;

	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public DBDao() throws ClassNotFoundException, SQLException{
		setDatabaseManager(DatabaseManagerSingletonFactory.getInstance());
	}

	

}
