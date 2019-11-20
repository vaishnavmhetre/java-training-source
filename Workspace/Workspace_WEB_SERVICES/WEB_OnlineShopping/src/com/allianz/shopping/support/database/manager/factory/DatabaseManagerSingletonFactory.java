/**
 * 
 */
package com.allianz.shopping.support.database.manager.factory;

import java.sql.SQLException;

import com.allianz.shopping.support.base.context.properties.ContextPropertiesSingletonFactory;
import com.allianz.shopping.support.database.manager.DatabaseManager;

/**
 * @author Allianz3076
 *
 */
public class DatabaseManagerSingletonFactory {

	private static volatile DatabaseManager databaseManager;

	public static DatabaseManager getInstance() throws ClassNotFoundException, SQLException {
		if (databaseManager == null) { // if there is no instance available... create new one
			synchronized (DatabaseManager.class) {
				if (databaseManager == null)
					databaseManager = new DatabaseManager(ContextPropertiesSingletonFactory.getInstance());
			}
		}

		return databaseManager;
	}

}
