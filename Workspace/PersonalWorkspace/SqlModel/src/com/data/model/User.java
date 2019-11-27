/**
 * 
 */
package com.data.model;

import com.support.database.annotation.sql.Column;
import com.support.database.annotation.sql.Table;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.Model;

/**
 * @author Allianz3076
 *
 */
@Table
public class User extends Model<User> {

	/*
	 * Adding explicit casts to the flow if necessary
	 * 
	 * public static Map<Class<?>, Class<?>> casts = new HashMap<Class<?>,
	 * Class<?>>() {
	 * 
	 * 
	 * { put(String.class, StringCaster.class); put(Integer.class,
	 * IntegerCaster.class); put(Float.class, FloatCaster.class); put(Long.class,
	 * LongCaster.class); }
	 * 
	 * };
	 */

	public User(DatabaseManager databaseManager) {
		super(User.class, databaseManager);
	}

	public User() {
		this(null);
	}

	@Column
	String name;

	@Column()
	String username;

	@Column
	String password;

	@Column
	int id;

	String any;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the any
	 */
	public String getAny() {
		return any;
	}

	/**
	 * @param any the any to set
	 */
	public void setAny(String any) {
		this.any = any;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + ", id=" + id + ", any="
				+ any + "]";
	}

}
