/**
 * 
 */
package com.servlet.auth.support.auth;

import java.sql.ResultSet;
import java.util.Properties;

import com.servlet.auth.support.auth.contract.AuthenticationManagerContract;
import com.servlet.auth.support.dao.LoginDao;

/**
 * @author Allianz3076
 *
 */
public class AuthenticationManager implements AuthenticationManagerContract {

	@Override
	public boolean check(String username, String password) throws Exception {
		LoginDao lDao = new LoginDao();
		ResultSet result = lDao.getUsernameAndPasswordEqualedOnlyOne(username, password);

		return result.first();
	}

}
