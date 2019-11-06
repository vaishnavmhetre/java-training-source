/**
 * 
 */
package com.interfaces;

import java.util.Arrays;

/**
 * TODO - Write interface for Stack
 * 
 * Functions: - push - pop
 * 
 * Create impl of that interface Create interface pointer, assign impl object to
 * it Then use array as stack and run functions over it
 * 
 */

interface StackContract<DType> {
	void push(DType item);

	DType pop();
}

abstract class Stack<DType> implements StackContract<DType>{
	
	
}

class StringStack extends Stack<String> {

	protected String[] stack;
	protected int head;

	StringStack(int capacity) {
		stack = new String[capacity];
		head = -1;
	}

	@Override
	public void push(String item) {
		stack[++head] = item;
	}

	@Override
	public String pop() {
		String item = stack[head];
		stack[head--] = null;
		return item;
	}

	public void printStack() {
		System.out.println(String.format("Stack: %s", Arrays.toString(stack)));
		System.out.println(String.format("Head: %d", head + 1));
	}
}

/**
 * @author Allianz3076
 *
 */
public class Test_Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringStack stack = new StringStack(5);

		stack.push("4");
		stack.printStack();
		System.out.println(String.format("Popped: %s", stack.pop()));
		stack.printStack();
	}

}
