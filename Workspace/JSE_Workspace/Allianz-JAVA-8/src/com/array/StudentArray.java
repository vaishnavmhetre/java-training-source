/**
 * 
 */
package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.classes.Student;

/**
 * @author Allianz3076
 *
 */
public class StudentArray {

	protected Student[] db;
	protected IntStack deletedIndexes;
	protected int newEntryIndex;
	protected int capacity;

	/**
	 * @return the db
	 */
	public Student[] getDb() {
		return db;
	}

	/**
	 * @param db
	 *            the db to set
	 */
	protected void setDb(Student[] db) {
		this.db = db;
	}

	/**
	 * @return the deletedIndexes
	 */
	protected IntStack getDeletedIndexes() {
		return deletedIndexes;
	}

	/**
	 * @param deletedIndexes
	 *            the deletedIndexes to set
	 */
	protected void setDeletedIndexes(IntStack deletedIndexes) {
		this.deletedIndexes = deletedIndexes;
	}

	/**
	 * @return the newEntryIndex
	 */
	protected int getNewEntryIndex() {
		return newEntryIndex;
	}

	/**
	 * @param newEntryIndex
	 *            the newEntryIndex to set
	 */
	protected void setNewEntryIndex(int newEntryIndex) {
		this.newEntryIndex = newEntryIndex;
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

	public StudentArray(int capacity) {
		setCapacity(capacity);
		setDb(new Student[capacity]);
		setDeletedIndexes(new IntStack(capacity));
		setNewEntryIndex(0);
	}

	protected int incrementNewEntryIndex() {
		setNewEntryIndex(getNewEntryIndex() + 1);
		return getNewEntryIndex();
	}

	public int add(Student student) {
		int insertIndex = getNewEntryIndex();
		if (hasAnyDeletedIndex())
			insertIndex = getDeletedIndex();
		else {
			if (getNewEntryIndex() + 1 >= getCapacity())
				return -1;
			else
				incrementNewEntryIndex();
		}

		db[insertIndex] = student;
		return insertIndex;
	}

	protected Student deleteByIndex(int index) {
		Student student = findByIndex(index);

		db[index] = null;
		deletedIndexes.push(index);
		return student;
	}

	public Student delete(int rollNo) {
		int index = getStudentIndexByRollNo(rollNo);
		if (index < 0)
			return null;
		else
			return deleteByIndex(index);
	}

	public Student findByIndex(int index) {
		return (index > -1) ? db[index] : null;
	}

	public Student findByRollNo(int rollNo) {
		for (Student student : db)
			if (student != null && student.getRollNo() == rollNo)
				return student;

		return null;
	}

	protected int getStudentIndexByRollNo(int rollNo) {
		Student[] students = getDb();
		for (int iter = 0; iter < students.length; iter++)
			if (students[iter] != null && students[iter].getRollNo() == rollNo)
				return iter;

		return -1;
	}

	protected boolean hasAnyDeletedIndex() {
		return deletedIndexes.canPop();
	}

	protected int getDeletedIndex() {
		return deletedIndexes.pop();
	}

	public Student[] getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		for (Student student : getDb()) 
			if (student != null)
				students.add(student);
		

		return students.toArray(new Student[students.size()]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StudentArray studentArray = new StudentArray(11);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(
					"\n 1. Add Student\n 2. Find Student\n 3. Delete Student\n 4. List students\n 5. Exit\nOption:");

			int opt = scanner.nextInt();

			switch (opt) {
			case 1:
				System.out.println("Enter roll no.: ");
				int newRollNo = scanner.nextInt();
				System.out.println("Enter name: ");
				String newName = scanner.next();
				System.out.println("Enter marks: ");
				float newMarks = scanner.nextFloat();
				Student newStudent = new Student(newRollNo, newName, newMarks);
				int insertIndex = studentArray.add(newStudent);
				if (insertIndex < 0)
					System.out.println(String.format("No space available. Failed to save Student data for roll no. %d.",
							newRollNo));
				else
					System.out.println(
							String.format("Student data for roll no. %d saved successfully", newStudent.getRollNo()));
				break;
			case 2:
				System.out.println("Enter roll no. to search for: ");
				int findRollNo = scanner.nextInt();
				Student findStudent = studentArray.findByRollNo(findRollNo);
				if (findStudent == null)
					System.out.println(String.format("Student data for roll no. %d not found", findRollNo));
				else
					System.out.println(findStudent);
				break;
			case 3:
				System.out.println("Enter roll no. of record to delete: ");
				int deleteRollNo = scanner.nextInt();
				Student deleteStudent = studentArray.delete(deleteRollNo);
				if (deleteStudent == null)
					System.out.println(String.format("Student data for roll no. %d not found", deleteRollNo));
				else
					System.out.println(String.format("Student data for roll no. %d deleted successfully",
							deleteStudent.getRollNo()));
				break;
			case 4:
				System.out.println("List of all Students: ");
				Student[] studentsList = studentArray.getAllStudents();
				for (Student student : studentsList)
					System.out.println(student);
				break;
			case 5:
				System.out.println("Exiting now...");
				break;
			default:
				break;
			}

			if (opt == 5)
				break;

		}
		scanner.close();
		System.out.println("Bye..!");
	}

}
