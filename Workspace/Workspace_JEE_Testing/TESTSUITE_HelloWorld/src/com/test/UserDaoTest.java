package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.data.dao.UserDao;
import com.data.model.User;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {

	@Test
	public void _1_saveUserTest() {
		User user = new User("Vaishnav", "Pune", 234563l);

		try {
			int status = new UserDao().save(user);

			assertTrue(status > 0);

		} catch (ClassNotFoundException | SQLException | InvalidQueryBuilderParameter e) {
			fail(e);
		}

	}

	@Test
	public void _2_deleteUserTest() {

		try {
			User user = new UserDao().getFirst();
			
			int status = new UserDao().delete(user);

			assertTrue(status > 0);

		} catch (ClassNotFoundException | SQLException e) {
			fail(e);
		}

	}
}
