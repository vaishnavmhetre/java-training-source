/**
 * 
 */
package com.basic;

import java.util.Arrays;

/**
 * @author Allianz3076
 *
 */
public class RandomArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = new int[10];

		System.out.println(nums);

		for (int index = 0; index < nums.length; index++) {
			nums[index] = (int) (Math.random() * 100);
		}

		System.out.print("Odd values: ");
		printArray(getOdds(nums));

		System.out.print("Even values: ");
		printArray(getEvens(nums));

	}

	private static int[] getOdds(int[] data) {
		int[] result = new int[] {};
		int iter = 0;
		for (int elem : data)
			if (elem % 2 == 1)
				result[iter++] = elem;
		return result;
	}

	private static int[] getEvens(int[] data) {
		int[] result = new int[] {};
		int iter = 0;
		for (int elem : data)
			if (elem % 2 == 0)
				result[iter++] = elem;
		return result;
	}

	private static void printArray(int[] arrayData) {
		System.out.print(Arrays.toString(arrayData));
	}

}
