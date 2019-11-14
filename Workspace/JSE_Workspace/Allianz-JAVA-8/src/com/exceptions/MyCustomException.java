/**
 * 
 */
package com.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Allianz3076
 *
 */
public class MyCustomException {

	public static void main(String[] args) {
		int no1, no2, result;

		try {
			System.setIn(new FileInputStream(new File("infile.dat")));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return;
		}

		Scanner scanner = new Scanner(System.in);

		System.out.println("Starting...");

		try {
			System.setErr(new PrintStream(new File("err.log")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
//			no1 = Integer.parseInt(args[0]);
			no1 = scanner.nextInt();
			System.out.println("1st argument processed: " + no1);
//			no2 = Integer.parseInt(args[1]);
			no2 = scanner.nextInt();
			System.out.println("2nd argument processed: " + no2);
			result = divide(no1, no2);

			System.out.println("Arithmetic operation performed result: " + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERR: Please enter 2 parameters");
		} catch (NumberFormatException e) {
			System.err.println("ERR: Please enter numeric values only");
		} catch (DivideByZeroException e) {
			System.err.println("ERR: " + e.getLocalizedMessage());
		} catch (Exception e) {
			System.err.println("ERR: " + e.getLocalizedMessage());
		}
		System.out.println("Ending...");

		scanner.close();
	}

	public static int divide(int no1, int no2) throws DivideByZeroException {
		if (no2 <= 0)
			throw new DivideByZeroException("Can not divide by ZERO or -VE number");
		return no1 / no2;
	}

}

class DivideByZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DivideByZeroException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DivideByZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DivideByZeroException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DivideByZeroException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DivideByZeroException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
