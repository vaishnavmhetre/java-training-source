/**
 * 
 */
package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Allianz3076
 *
 */
public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		fileInputStream();

	}

	public static void fileInputStream() {
		// FileInputStream Example

		File file = new File("ipFile.dat");

		try (FileInputStream fStream = new FileInputStream(file)) {

			int value = 0;
			while ((value = fStream.read()) != -1)
				System.out.print((char) value);

		} catch (FileNotFoundException e) {
			System.err.println("ERR: File not found [" + e.getMessage() + "]");
		} catch (IOException e) {
			System.err.println("ERR: IO Error [" + e.getMessage() + "]");
		}
	}

	public static void fileOutputStream() {
		File file = new File("opfile.dat");
		String message = "This is my lovely output file";

		try (FileOutputStream fStream = new FileOutputStream(file)) {
			byte[] bytes = message.getBytes();
			fStream.write(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
