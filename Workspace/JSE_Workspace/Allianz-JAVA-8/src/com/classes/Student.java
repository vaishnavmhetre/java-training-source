/**
 * 
 */
package com.classes;

/**
 * @author Allianz3076
 *
 */
public class Student {

	private int rollNo;
	private String name;
	private float marks;

	public Student() {
		rollNo = 0;
		name = "";
		marks = 0.0f;
//		System.out.println("Student -> default...");
	}

	public Student(int rollNo, String name, float marks) {
		setRollNo(rollNo);
		setName(name);
		setMarks(marks);
//		System.out.println("Student -> parameterized...");
	}

	public Student(Student student) {
		setRollNo(student.getRollNo());
		setName(student.getName());
		setMarks(student.getMarks());
//		System.out.println("Student -> copy...");
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

	@Override
	public String toString() {
		return String.format("Roll no: %d, Name: %s, Marks: %f", rollNo, name, marks);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj == this)
			return false;
		else if (!(obj instanceof Student))
			return false;

		Student student = (Student) obj;

		if (this.getRollNo() == student.getRollNo() && this.getName().equals(student.getName())
				&& this.getMarks() == student.getMarks())
			return true;

		return false;
	}

	public static void main(String[] args) {
		Student s1, s2, s3;

		s1 = new Student();
//		s2 = new Student();
		s2 = new Student(102, "Akbar", 85.5f);
		s3 = new Student(s2);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		if (s2 == s3)
			System.out.println("s2 == s3");
		else
			System.out.println("s2 != s3");

		if (s2.equals(s3))
			System.out.println("s2 equals s3");
		else
			System.out.println("s2 not equals s3");
		
	}
}
