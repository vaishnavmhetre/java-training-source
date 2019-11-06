/**
 * 
 */
package com.basic;

/**
 * @author Allianz3076
 *
 */
public class Calender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);

		System.out.print(getDays(month, year));
	}

	private static int getDays(int month, int year) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			return febDays(year);
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;

		default:
			return -1;
		}
	}

	private static boolean leapYear(int year) {
		return year % 400 == 0;
	}

	private static int febDays(int year) {
		return leapYear(year) ? 29 : 28;
	}

}
