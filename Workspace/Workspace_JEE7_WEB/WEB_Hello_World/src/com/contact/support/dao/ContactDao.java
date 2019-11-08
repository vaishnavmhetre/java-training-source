/**
 * 
 */
package com.contact.support.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.servlet.auth.support.querybuilder.SqlQueryBuilder;
import com.servlet.auth.support.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.servlet.auth.support.querybuilder.sql.support.SqlQueryCondition;
import com.support.database.manager.DatabaseManager;
import com.support.database.manager.factory.DatabaseManagerSingletonFactory;

/**
 * @author Allianz3076
 *
 */
public class ContactDao {

	protected Properties properties;
	protected DatabaseManager databaseManager;
	protected String tableName = "contacts";

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

	public ContactDao() throws ClassNotFoundException, SQLException {
		setDatabaseManager(DatabaseManagerSingletonFactory.getInstance());
	}

	public int delete(int id) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("id", "=", id));

		String query = new SqlQueryBuilder(getTableName()).delete(conditions);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}
	
	public int insert(String name, int number, String address) throws SQLException, InvalidQueryBuilderParameter {
		List<String> columns = Arrays.asList("name", "number", "address");
		List<Object> values = Arrays.asList(name, number, address);

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}
	
	public int update(int id, String name, int number, String address) throws InvalidQueryBuilderParameter, SQLException {		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("name", name);
		map.put("number",number);
		map.put("address", address);
		
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("id", "=", id));

		String query = new SqlQueryBuilder(getTableName()).update(map, conditions);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}

}
