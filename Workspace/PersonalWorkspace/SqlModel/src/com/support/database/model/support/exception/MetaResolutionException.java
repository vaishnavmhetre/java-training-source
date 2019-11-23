/**
 * 
 */
package com.support.database.model.support.exception;

/**
 * @author Allianz3076
 *
 */
public class MetaResolutionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MetaResolutionException() {
	}

	/**
	 * @param arg0
	 */
	public MetaResolutionException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public MetaResolutionException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public MetaResolutionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public MetaResolutionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
