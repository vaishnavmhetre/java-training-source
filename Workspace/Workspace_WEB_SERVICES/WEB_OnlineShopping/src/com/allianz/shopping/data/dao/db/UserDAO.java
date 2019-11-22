/**
 * 
 */
package com.allianz.shopping.data.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.allianz.shopping.data.dao.db.support.DBDao;
import com.allianz.shopping.data.model.User;
import com.allianz.shopping.support.database.querybuilder.SqlQueryBuilder;
import com.allianz.shopping.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
import com.allianz.shopping.support.database.querybuilder.sql.support.SqlQueryCondition;
import com.allianz.shopping.support.database.querybuilder.sql.support.flags.SqlQueryBuilderFlags;

/**
 * @author Allianz3076
 *
 */
public class UserDAO extends DBDao {

	public UserDAO() throws ClassNotFoundException, SQLException {
		super();
		setTableName("users");
	}

	public User getUsernameAndPasswordEqualsLimitOne(String username, String password) {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("username", "=", username),
				new SqlQueryCondition(SqlQueryBuilderFlags.CONDITION_JOINER_AND),
				new SqlQueryCondition("password", "=", password));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		try {
			ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);
			rs.next();
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setUsername(rs.getString("username"));

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int createUser(User user) {
		List<String> columns = Arrays.asList("name", "username", "password");
		List<Object> values = Arrays.asList(user.getName(), user.getUsername(), user.getPassword());

		try {
			String query = new SqlQueryBuilder(getTableName()).insert(values, columns);
			return getDatabaseManager().createStatement().executeUpdate(query);
		} catch (InvalidQueryBuilderParameter | SQLException e) {
			e.printStackTrace();
		}

		return -1;

	}

	public User findUserById(int id) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays.asList(new SqlQueryCondition("id", "=", id));

		String query = new SqlQueryBuilder(getTableName()).select_limited(null, conditions, 1);

		ResultSet rs = getDatabaseManager().createStatement().executeQuery(query);

		if (!rs.first())
			return null;

		// rs.next();

		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));

		return user;
	}

	public User getRandomUser() {
		// TODO - find a random user in database
		return null; // return the random User
	}
}
