/**
 * 
 */
package com.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class Calculator {
	
	private static final String[] allowedOperators = { "+", "-" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		List<String> operators = new ArrayList<String>();
		List<Integer> operands = new ArrayList<Integer>();
		
		for (String arg : args) {
			if (hasOperator(arg, allowedOperators))
				operators.add(arg);
			else
				operands.add(Integer.parseInt(arg));
		}
		

		int result = operands.get(0);
		int opriter = 1;

		while (opriter < operands.size()) {
			switch (operators.get(opriter / 2)) {
			case "+":
				result = add(result, operands.get(opriter));
				break;
			case "-":
				result = subtract(result, operands.get(opriter));
				break;
			}
			
			opriter+=2;
		}

		System.out.print(String.format("Result= %d", result));
	}

	public static int add(int num1, int num2) {
		return num1 + num2;
	}

	public static int subtract(int num1, int num2) {
		return num1 - num2;
	}

	private static boolean hasOperator(String operator, String[] allowedOperators) {
		for (String opr : allowedOperators)
			if (opr.equals(operator))
				return true;

		return false;
	}

}
