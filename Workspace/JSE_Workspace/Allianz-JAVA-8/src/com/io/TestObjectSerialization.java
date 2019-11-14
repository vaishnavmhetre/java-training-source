/**
 * 
 */
package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Allianz3076
 *
 */
public class TestObjectSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Student> listStudents = Arrays.asList(new Student(78, "Vaishnav", 34.3f), new Student(21, "Sachin", 24.2f),
				new Student(32, "Rahul", 45.6f), new Student(76, "Shital", 98.1f));

		File file = new File("studData.dat");

		writeToFile(listStudents, file);

		System.out.println("Written to File Successfully");
		listStudents = null;
		System.out.print("Data in listStudents (after nulled): ");
		System.out.println(listStudents);

		listStudents = readFromFile(file);

		System.out.print("Data in listStudents (after reading from file): ");
		System.out.println(listStudents);

	}

	public static void writeToFile(List<Student> listStudents, File file) {
		try {
			FileOutputStream fStream = new FileOutputStream(file);
			ObjectOutputStream oStream = new ObjectOutputStream(fStream);

			oStream.writeObject(listStudents);
			oStream.flush();
			oStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Student> readFromFile(File file) {

		try {
			FileInputStream fStream = new FileInputStream(file);
			ObjectInputStream oStream = new ObjectInputStream(fStream);

			List<Student> listStudents = (List<Student>) oStream.readObject();
			oStream.close();
			return listStudents;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

}
