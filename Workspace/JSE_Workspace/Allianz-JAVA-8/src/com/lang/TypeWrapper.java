/**
 * 
 */
package com.lang;

/**
 * @author Allianz3076
 *
 */
public class TypeWrapper {
	
	public static void printByteData() {
		System.out.println("Byte.MIN_VALUE: "+Byte.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE: "+Byte.MAX_VALUE);
		System.out.println("Byte.SIZE: "+Byte.SIZE);
	}
	
	public static void printIntegerData() {
		System.out.println("Integer.MIN_VALUE: "+Integer.MIN_VALUE);
		System.out.println("Integer.MAX_VALUE: "+Integer.MAX_VALUE);
		System.out.println("Integer.SIZE: "+Integer.SIZE);
	}
	
	public static void printFloatData() {
		System.out.println("Float.MIN_VALUE: "+Float.MIN_VALUE);
		System.out.println("Float.MAX_VALUE: "+Float.MAX_VALUE);
		System.out.println("Float.SIZE: "+Float.SIZE);
	}

	public static void printDoubleData() {
		System.out.println("Double.MIN_VALUE: "+Double.MIN_VALUE);
		System.out.println("Double.MAX_VALUE: "+Double.MAX_VALUE);
		System.out.println("Double.SIZE: "+Double.SIZE);
	}
	
	public static void printShortData() {
		System.out.println("Short.MIN_VALUE: "+Short.MIN_VALUE);
		System.out.println("Short.MAX_VALUE: "+Short.MAX_VALUE);
		System.out.println("Short.SIZE: "+Short.SIZE);
	}
	
	public static void printLongData() {
		System.out.println("Long.MIN_VALUE: "+Long.MIN_VALUE);
		System.out.println("Long.MAX_VALUE: "+Long.MAX_VALUE);
		System.out.println("Long.SIZE: "+Long.SIZE);
	}
	
	public static void printCharacterData() {
		System.out.println("Character.MIN_VALUE: "+Character.MIN_VALUE);
		System.out.println("Character.MAX_VALUE: "+Character.MAX_VALUE);
		System.out.println("Character.SIZE: "+Character.SIZE);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		printByteData();
		System.out.println();
		printIntegerData();
		System.out.println();
		printCharacterData();
		System.out.println();
		printDoubleData();
		System.out.println();
		printFloatData();
		System.out.println();
		printLongData();
		System.out.println();
		printShortData();
		System.out.println();
		
	}

}
