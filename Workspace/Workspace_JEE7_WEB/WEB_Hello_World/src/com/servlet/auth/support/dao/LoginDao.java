/**
 * 
 */
package com.servlet.auth.support.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.servlet.auth.support.querybuilder.SqlQueryBuilder;
import com.servlet.auth.support.querybuilder.sql.support.SqlQueryCondition;
import com.servlet.auth.support.querybuilder.sql.support.flags.SqlQueryBuilderFlags;
import com.support.database.manager.DatabaseManager;
import com.support.database.manager.factory.DatabaseManagerSingletonFactory;

/**
 * @author Allianz3076
 *
 */
public class LoginDao {
	protected Properties properties;
	protected DatabaseManager databaseManager;
	protected String tableName = "users";

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

	public LoginDao() throws ClassNotFoundException, SQLException{
		setDatabaseManager(DatabaseManagerSingletonFactory.getInstance());
	}

	public ResultSet getUsernameAndPasswordEqualedOnlyOne(String username, String password) throws SQLException {
		List<String> columns = Arrays.asList("username", "password");
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("username", "=", username),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_AND),
				new SqlQueryCondition("password", "=", password));

		String query = new SqlQueryBuilder(getTableName()).select_limited(columns, conditions, 1);

		return getDatabaseManager().createStatment().executeQuery(query);
	}
}
