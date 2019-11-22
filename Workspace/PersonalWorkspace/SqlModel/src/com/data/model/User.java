/**
 * 
 */
package com.data.model;

import com.support.database.annotation.Column;
import com.support.database.model.Model;

/**
 * @author Allianz3076
 *
 */
public class User extends Model<User> {

	public User() {
		super(User.class);
	}
	
	public User(int id) {
		super(User.class);
	}

	@Column(columnName="name1")
	String name;

	@Column
	String email;

	String any;

}
