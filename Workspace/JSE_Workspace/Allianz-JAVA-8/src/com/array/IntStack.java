/**
 * 
 */
package com.array;

/**
 * @author Allianz3076
 *
 */
public class IntStack {
	protected int[] stack;
	protected int head;
	protected int capacity;

	/**
	 * @return the stack
	 */
	public int[] getStack() {
		return stack;
	}

	/**
	 * @param stack
	 *            the stack to set
	 */
	protected void setStack(int[] stack) {
		this.stack = stack;
	}

	/**
	 * @return the head
	 */
	public int getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(int head) {
		this.head = head;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 *            the capacity to set
	 */
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public IntStack(int capacity) {
		setCapacity(capacity);
		setStack(new int[capacity]);
		setHead(-1);
	}

	public void push(int item) {
		if (canPush()) {
			setHead(getHead() + 1);
			stack[getHead()] = item;
		}
	}

	public int pop() {
		if (canPop()) {
			int item = stack[getHead()];
			stack[getHead()] = -1;
			setHead(getHead() - 1);
			return item;
		}
		return -1;
	}

	public boolean canPop() {
		return getHead() > 0;
	}

	public boolean canPush() {
		return getHead() + 1 < getCapacity();
	}

}
