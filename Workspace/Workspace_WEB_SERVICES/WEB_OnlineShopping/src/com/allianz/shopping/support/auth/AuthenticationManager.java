/**
 * 
 */
package com.allianz.shopping.support.auth;

import java.sql.SQLException;

import com.allianz.shopping.data.dao.db.UserDAO;
import com.allianz.shopping.data.model.User;
import com.allianz.shopping.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

/**
 * @author Allianz3076
 *
 */
public class AuthenticationManager {

	
	public static User login(String username, String password) throws SQLException, ClassNotFoundException, InvalidQueryBuilderParameter {
		
		User user = new UserDAO().getUsernameAndPasswordEqualsLimitOne(username, password);
		
		return user;
	}
}
