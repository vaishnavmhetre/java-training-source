/**
 * 
 */
package com.servlet.auth.support.auth.contract;

/**
 * @author Allianz3076
 *
 */
public interface AuthenticationManagerContract {
	public boolean check(String username, String password) throws Exception;
}
