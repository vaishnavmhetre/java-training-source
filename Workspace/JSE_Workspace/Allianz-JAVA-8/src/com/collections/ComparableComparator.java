/**
 * 
 */
package com.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class ComparableComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> listNames = Arrays.asList("John", "Peter", "Tom", "Mary", "Lisa");
		List<Integer> listNumbers = Arrays.asList(1, 3, 5, 2, 7, 3, 9, 5);

		System.out.println("\nString sorting");
		System.out.println("Before: " + listNames);
		Collections.sort(listNames);
		System.out.println("After: " + listNames);

		System.out.println("\nInteger sorting");
		System.out.println("Before: " + listNumbers);
		Collections.sort(listNumbers);
		System.out.println("After: " + listNumbers);

		List<Circle> listCircles = Arrays.asList(new Circle(78), new Circle(32), new Circle(45), new Circle(23));

		System.out.println("\nCircle sorting");
		System.out.println("Before: " + listCircles);
		Collections.sort(listCircles);
		System.out.println("After: " + listCircles);

		List<Student> listStudents = Arrays.asList(new Student(78, "Vaishnav", 34.3f), new Student(21, "Sachin", 24.2f),
				new Student(32, "Rahul", 45.6f), new Student(76, "Shital", 98.1f));
		
		System.out.println("\nStudent sorting");
		System.out.println("Before: " + listStudents);
		System.out.println();
		
		Collections.sort(listStudents, Student.RollNoComparator);
		System.out.println("After RollNoComparator: " + listStudents);
		System.out.println();
		
		Collections.sort(listStudents, Student.NameComparator);
		System.out.println("After NameComparator: " + listStudents);
		System.out.println();
		
		Collections.sort(listStudents, Student.MarksComparator);
		System.out.println("After MarksComparator: " + listStudents);
		System.out.println();
	}

}
