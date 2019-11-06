/**
 * 
 */
package com.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Allianz3076
 *
 */
public class ThreadReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Thread printer = new Thread(new LazyPrinter(new FileReader("infile.dat"), 500));
			printer.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class LazyPrinter implements Runnable {

	protected Reader reader;
	protected BufferedReader buffer;
	protected int sleepTime;

	/**
	 * @return the reader
	 */
	public Reader getReader() {
		return reader;
	}

	/**
	 * @param reader
	 *            the reader to set
	 */
	protected void setReader(Reader reader) {
		this.reader = reader;
	}

	/**
	 * @return the buffer
	 */
	public BufferedReader getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer
	 *            the buffer to set
	 */
	protected void setBuffer(BufferedReader buffer) {
		this.buffer = buffer;
	}
	
	

	/**
	 * @return the sleepTime
	 */
	public int getSleepTime() {
		return sleepTime;
	}

	/**
	 * @param sleepTime the sleepTime to set
	 */
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	/**
	 * @param reader
	 */
	public LazyPrinter(Reader reader, int sleepTime) {
		setReader(reader);
		setBuffer(new BufferedReader(reader));
		setSleepTime(sleepTime);
	}
	

	@Override
	public void run() {
		String line = "";
		try {
			while(
					(line = getBuffer().readLine())
					!= null) {
				System.out.println(line);
				Thread.sleep(getSleepTime());
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
