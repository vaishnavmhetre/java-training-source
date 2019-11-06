/**
 * 
 */
package com.collections;

import java.util.Comparator;

/**
 * @author Allianz3076
 *
 */
public class Student {

	private int rollNo;
	private String name;
	private float marks;

	public Student(int rollNo, String name, float marks) {
		setRollNo(rollNo);
		setName(name);
		setMarks(marks);
	}

	public Student(Student student) {
		setRollNo(student.getRollNo());
		setName(student.getName());
		setMarks(student.getMarks());
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	

	public static Comparator<Student> RollNoComparator = new Comparator<Student>() {

		@Override
		public int compare(Student thisStudent, Student thatStudent) {
			return ((Integer)(thisStudent.getRollNo())).compareTo(thatStudent.getRollNo());
		}

	};

	public static Comparator<Student> NameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student thisStudent, Student thatStudent) {
			return thisStudent.getName().compareTo(thatStudent.getName());
		}

	};

	public static Comparator<Student> MarksComparator = new Comparator<Student>() {

		@Override
		public int compare(Student thisStudent, Student thatStudent) {
			return ((Float)(thisStudent.getMarks())).compareTo(thatStudent.getMarks());
		}

	};
}
