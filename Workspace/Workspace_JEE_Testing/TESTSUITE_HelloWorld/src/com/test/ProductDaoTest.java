package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.data.dao.ProductDao;
import com.data.model.Product;
import com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {

	@Test
	public void _1_saveProductTest() {
		Product product = new Product("Fan", "Electronics", 3200.00f);

		try {
			int status = new ProductDao().save(product);

			assertTrue(status > 0);

		} catch (ClassNotFoundException | SQLException | InvalidQueryBuilderParameter e) {
			fail(e);
		}

	}

	@Test
	public void _2_deleteProductTest() {

		try {
			Product product = new ProductDao().getFirst();

			int status = new ProductDao().delete(product);

			assertTrue(status > 0);

		} catch (ClassNotFoundException | SQLException e) {
			fail(e);
		}

	}

}
