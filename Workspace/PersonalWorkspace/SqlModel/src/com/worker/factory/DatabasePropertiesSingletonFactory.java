/**
 * 
 */
package com.worker.factory;

import java.util.HashMap;
import java.util.Map;

import com.support.database.properties.DatabaseProperties;

/**
 * @author Allianz3076
 *
 */
public class DatabasePropertiesSingletonFactory {
	private static volatile DatabaseProperties contextProperties;

	private static Map<String, String> properties = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("db.driver", "com.mysql.cj.jdbc.Driver");
			put("db.url", "jdbc:mysql://localhost:3306/allianz?serverTimezone=UTC");
			put("db.username", "root");
			put("db.password", "");
		}

	};

	public static DatabaseProperties getInstance() {
		if (contextProperties == null) { // if there is no instance available... create new one
			synchronized (DatabaseProperties.class) {
				if (contextProperties == null) {
					contextProperties = new DatabaseProperties();

					contextProperties.putAll(properties);
				}
			}
		}
		return contextProperties;
	}
}
