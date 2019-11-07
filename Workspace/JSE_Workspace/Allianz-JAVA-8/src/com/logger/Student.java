/**
 * 
 */
package com.logger;

import org.apache.log4j.Logger;

/**
 * @author Allianz3076
 *
 */
public class Student {
	private static Logger LOGGER = Logger.getLogger(Student.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Info message");
		LOGGER.debug("Debug message");
		LOGGER.warn("Warn message");
		LOGGER.error("Error message");
		LOGGER.fatal("Fatal message");
		System.out.println("Done processing");
	}

}
