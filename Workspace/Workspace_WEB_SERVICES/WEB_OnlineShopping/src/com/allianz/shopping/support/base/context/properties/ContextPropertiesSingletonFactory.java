/**
 * 
 */
package com.allianz.shopping.support.base.context.properties;

/**
 * @author Allianz3076
 *
 */
public class ContextPropertiesSingletonFactory {

	private static volatile ContextProperties contextProperties;

	public static ContextProperties getInstance() {
		if (contextProperties == null) { // if there is no instance available... create new one
			synchronized (ContextProperties.class) {
				if (contextProperties == null)
					contextProperties = new ContextProperties();
			}
		}

		return contextProperties;
	}
}
