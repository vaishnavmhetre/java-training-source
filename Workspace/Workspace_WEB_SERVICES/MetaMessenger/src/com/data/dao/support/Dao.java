package com.data.dao.support;

import java.sql.SQLException;
import java.util.Properties;

import com.support.database.manager.DatabaseManager;
import com.support.database.manager.factory.DatabaseManagerSingletonFactory;

public class Dao {

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

	public Dao() throws ClassNotFoundException, SQLException{
		setDatabaseManager(DatabaseManagerSingletonFactory.getInstance());
	}

	

}
