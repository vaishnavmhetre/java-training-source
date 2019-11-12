/**
 * 
 */
package com.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.data.dao.support.Dao;
import com.data.model.User;
import com.support.database.querybuilder.SqlQueryBuilder;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class UserDAO extends Dao {

	public UserDAO() throws ClassNotFoundException, SQLException {
		super();
		setTableName("users");
	}

	public ResultSet getUsernameAndPasswordEqualsLimitOne(String username, String password) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("username", "=", username),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_AND),
				new SqlQueryCondition("password", "=", password));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		return getDatabaseManager().createStatment().executeQuery(query);
	}

	public int createUser(User user) throws InvalidQueryBuilderParameter, SQLException {
		List<String> columns = Arrays.asList("name", "username", "password");
		List<Object> values = Arrays.asList(user.getName(), user.getUsername(), user.getPassword());
		

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}

	public User findUserByToken(String token) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("token", "=", token));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		ResultSet rs =  getDatabaseManager().createStatment().executeQuery(query);
		
		if(!rs.first())
			return null;
		
		// rs.next();
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		
		return user;
	}
	
	public User findUserById(int id) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("id", "=", id));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		ResultSet rs =  getDatabaseManager().createStatment().executeQuery(query);
		
		if(!rs.first())
			return null;
		
		// rs.next();
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		
		return user;
	}
	
	public int setToken(int id, String token) throws InvalidQueryBuilderParameter, SQLException {
		Map<String, Object> values = new HashMap<String, Object>();
		
		values.put("token", token);
		
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("id", "=", id));
		
		String query = new SqlQueryBuilder(getTableName()).update(values, conditions);
		
		return getDatabaseManager().createStatment().executeUpdate(query);
	}
	
	public User getRandomUser() {
		// TODO - find a random user in database
		 return null; // return the random User
	}
}
