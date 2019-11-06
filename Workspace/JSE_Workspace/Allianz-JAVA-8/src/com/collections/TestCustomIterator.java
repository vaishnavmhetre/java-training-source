/**
 * 
 */
package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class TestCustomIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = new Integer[10];

		for (int index = 0; index < 10; index++)
			arr[index] = (int) (Math.random() * 100);

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

	}

	class OddIterator implements Iterator<Integer> {

		protected ArrayList<Integer> list;
		protected Integer lastFetchedPointer;

		public int getlastFetchedPointer() {
			return lastFetchedPointer;
		}

		public void setlastFetchedPointer(int pointer) {
			this.lastFetchedPointer = pointer;
		}

		public ArrayList<Integer> getList() {
			return list;
		}

		public void setList(ArrayList<Integer> list) {
			this.list = list;
		}

		public OddIterator(List<Integer> list) {
			setList((ArrayList<Integer>) list);
			setlastFetchedPointer(-1);
		}

		@Override
		public boolean hasNext() {
			return (nextIndex()> -1);
		}

		@Override
		public Integer next() {
			if(hasNext()) {
				Integer returnValue = list.get(nextIndex());
				setlastFetchedPointer(nextIndex());
				return returnValue;
			}
			
			return null;
		}

		protected Integer nextIndex() {
			for(int iter = getlastFetchedPointer(); iter<getList().size(); iter++)
				if(getList().get(iter)%2 == 1)
					return iter;
			
			return -1;
		}

	}

}
