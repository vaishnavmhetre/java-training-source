/**
 * 
 */
package com.studentdb.support.querybuilder.exceptions;

/**
 * @author Allianz3076
 *
 */
public class InvalidQueryBuilderParameter extends Exception {

	/**
	 * 
	 */
	public InvalidQueryBuilderParameter() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidQueryBuilderParameter(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidQueryBuilderParameter(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InvalidQueryBuilderParameter(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidQueryBuilderParameter(Throwable cause) {
		super(cause);
	}

}
