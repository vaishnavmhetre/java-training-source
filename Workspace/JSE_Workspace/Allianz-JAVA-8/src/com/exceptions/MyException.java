/**
 * 
 */
package com.exceptions;


/**
 * @author Allianz3076
 *
 */
public class MyException {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		if (args.length != 2) {
			System.out.println("Please provide runtime arguments");
			return;
		}

		int no1, no2, result;

		System.out.println("Starting...");

		no1 = Integer.parseInt(args[0]);
		System.out.println("1st argument processed: " + no1);
		no2 = Integer.parseInt(args[1]);
		System.out.println("2nd argument processed: " + no2);

		result = no1 / no2;

		System.out.println("Aruthmetic operation performed result: " + result);
		System.out.println("Ending...");
	}

	public static void main2(String[] args) {
		int no1, no2, result;

		System.out.println("Starting...");

		try {
			no1 = Integer.parseInt(args[0]);
			System.out.println("1st argument processed: " + no1);
			no2 = Integer.parseInt(args[1]);
			System.out.println("2nd argument processed: " + no2);
			result = no1 / no2;
			
			System.out.println("Arithmetic operation performed result: " + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERR: Please enter 2 parameters");
		} catch(NumberFormatException e) {
			System.err.println("ERR: Please enter numeric values only");
		} catch(ArithmeticException e) {
			System.err.println("ERR: Please enter non-zero values only");
		} catch(Exception e) {
			System.err.println("ERR: " + e.getLocalizedMessage());
		}
		System.out.println("Ending...");
	}
	
	public static void main(String[] args) {
		int no1, no2, result;

		System.out.println("Starting...");

		try {
			no1 = Integer.parseInt(args[0]);
			System.out.println("1st argument processed: " + no1);
			no2 = Integer.parseInt(args[1]);
			System.out.println("2nd argument processed: " + no2);
			result = divide(no1, no2);
			
			System.out.println("Arithmetic operation performed result: " + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERR: Please enter 2 parameters");
		} catch(NumberFormatException e) {
			System.err.println("ERR: Please enter numeric values only");
		} catch(Exception e) {
			System.err.println("ERR: " + e.getLocalizedMessage());
		}
		System.out.println("Ending...");
	}
	
	public static int divide(int no1, int no2) throws Exception{
		if(no2 <= 0)
			throw new Exception("Can not divide by ZERO or -VE number");
		return no1 / no2;
	}

}
