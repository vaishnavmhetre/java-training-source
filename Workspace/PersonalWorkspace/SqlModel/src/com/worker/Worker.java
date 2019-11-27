/**
 * 
 */
package com.worker;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.data.model.Product;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.data.builder.DataBuilder;
import com.support.database.model.support.exception.ModelProcessException;
import com.support.database.model.support.model.support.builder.Builder;
import com.support.database.query.builder.QueryBuilder;
import com.worker.factory.DatabasePropertiesSingletonFactory;

/**
 * @author Allianz3076
 *
 */
public class Worker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			DatabaseManager databaseManager = new DatabaseManager(DatabasePropertiesSingletonFactory.getInstance());

			/**
			 * Model methods approach
			 */
			System.out.println();
			System.out.println("***** Model methods approach *****");
			System.out.println();
			System.out.println("All -> " + new Product(databaseManager).all());
			System.out.println("First -> " + new Product(databaseManager).first());

			/**
			 * Model Builder to QueryBuilder approach
			 */
			System.out.println();
			System.out.println("*****  Model Builder to QueryBuilder approach *****");
			System.out.println();
			System.out.println(new Product(databaseManager).where("description", "sadsad").get());

			/**
			 * Builder auto-build to Model approach
			 */
			System.out.println();
			System.out.println("***** Builder auto-build to Model approach *****");
			System.out.println();
			Builder<Product> builder = new Builder<Product>(Product.class, databaseManager);
			System.out.println(builder.select().get());

			/*
			 * Manual QueryBuilder Approach
			 */
			System.out.println();
			System.out.println("***** Manual QueryBuilder Approach *****");
			System.out.println();
			QueryBuilder queryBuilder = new QueryBuilder(databaseManager);
			ResultSet rs = queryBuilder.table("products").select("id", "name").where("name", "asdsd").and().where("description", "something").get();
			while (rs.next())
				System.out.println((Product) DataBuilder.build(rs, Product.class, new Product().getColumnFields()));

		} catch (ModelProcessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
