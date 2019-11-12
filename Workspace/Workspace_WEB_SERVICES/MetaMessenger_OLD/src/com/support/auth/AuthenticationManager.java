/**
 * 
 */
package com.support.auth;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.data.dao.UserDAO;
import com.data.model.User;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

/**
 * @author Allianz3076
 *
 */
public class AuthenticationManager {

	
	public String login(String username, String password) throws SQLException, ClassNotFoundException, InvalidQueryBuilderParameter {
		
		ResultSet rs = new UserDAO().getUsernameAndPasswordEqualsLimitOne(username, password);
		
		if(!rs.first())
			return null;
		
//		rs.next();
		
		int id = rs.getInt("id");
		
		while(true) {
			String token = TokenGenerator.getAlphaNumericString(32);
			User user = new UserDAO().findUserByToken(token);
			
			if(user == null) {
				new UserDAO().setToken(id, token);
				return token;
			}
		}
	}
}
