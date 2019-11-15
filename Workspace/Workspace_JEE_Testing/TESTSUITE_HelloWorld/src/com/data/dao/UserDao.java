/**
 * 
 */
package com.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
public class UserDao extends Dao {

	public UserDao() throws ClassNotFoundException, SQLException {
		super();
		setTableName("users");
	}

	public User getFirst() throws SQLException {
		String query = new SqlQueryBuilder(getTableName()).select_limited(null, null, 1);

		ResultSet rs = getDatabaseManager().createStatment().executeQuery(query);

		rs.first();

		return new User(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getLong("contact"));
	}

	public int save(User user) throws SQLException, InvalidQueryBuilderParameter {
		List<String> columns = Arrays.asList("name", "address", "contact");
		List<Object> values = Arrays.asList(user.getName(), user.getAddress(), user.getContact());

		String query = new SqlQueryBuilder(getTableName()).insert(values, columns);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}

	public int delete(User user) throws SQLException {
		List<SqlQueryCondition> conditions = Arrays
				.asList(new SqlQueryCondition("id", SqlQueryBuilderFlags.CONDITION_EQUAL, user.getId()));
		String query = new SqlQueryBuilder(getTableName()).delete(conditions);

		return getDatabaseManager().createStatment().executeUpdate(query);
	}
}
