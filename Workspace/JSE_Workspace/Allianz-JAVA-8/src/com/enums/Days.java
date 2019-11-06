/**
 * 
 */
package com.enums;

/**
 * @author Allianz3076
 *
 */
public enum Days {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	public static void main(String[] args) {
		Days today = Days.MONDAY;

		if (today == Days.MONDAY)
			System.out.println("Today is Monday");
		for (Days day : Days.values()) 
			System.out.println(day);
		
	}
}
