/**
 * 
 */
package com.support.base.context.properties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Allianz3076
 *
 */
public class ContextPropertiesSingletonFactory {

	private static volatile ContextProperties contextProperties;

	private static Map<String, String> properties = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("db.driver", "com.mysql.cj.jdbc.Driver");
			put("db.url", "jdbc:mysql://localhost:3306/testsuiteexample?serverTimezone=UTC");
			put("db.username", "root");
			put("db.password", "");
		}

	};

	public static ContextProperties getInstance() {
		if (contextProperties == null) { // if there is no instance available... create new one
			synchronized (ContextProperties.class) {
				if (contextProperties == null) {
					contextProperties = new ContextProperties();

					contextProperties.putAll(properties);
				}
			}
		}
		return contextProperties;
	}
}
