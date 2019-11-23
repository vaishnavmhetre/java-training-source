/**
 * 
 */
package com.worker;

import java.sql.SQLException;

import com.data.model.Product;
import com.support.database.manager.DatabaseManager;
import com.support.database.model.support.exception.ModelProcessException;
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
		Product product = new Product();
		try {
			DatabaseManager databaseManager = new DatabaseManager(DatabasePropertiesSingletonFactory.getInstance());

			product.setDatabaseManager(databaseManager);

			System.out.println(product.all(null));

		} catch (ModelProcessException | ClassNotFoundException | SQLException e) {
			System.out.println(product);
			e.printStackTrace();
		}

	}

}
