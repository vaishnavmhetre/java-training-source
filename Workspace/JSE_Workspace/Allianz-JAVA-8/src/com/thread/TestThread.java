/**
 * 
 */
package com.thread;

/**
 * @author Allianz3076
 *
 */
public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Current Thread Routine - START");

		Thread currThread = Thread.currentThread();

		System.out.println("Name: " + currThread.getName() + "\tPriority: " + currThread.getPriority());
		currThread.setName("CurrThreadChanged");
		currThread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Name: " + currThread.getName() + "\tPriority: " + currThread.getPriority());

		for (int iter = 0; iter < 20; iter++)
			System.out.print("  " + iter);

		System.out.println("Current Thread Routine - END");

		System.out.println("Custom Runnable Thread Routine - START");
		Thread runThread = new Thread(new RunThread());
		runThread.setName("RunThread");
		runThread.start();
		System.out.println("Custom Runnable Thread Routine - END");

		System.out.println("Custom Extended Thread Routine - START");
		ExtendThread extendThread = new ExtendThread();
		extendThread.setName("ExtendThread");
		extendThread.start();
		System.out.println("Custom Extended Thread Routine - END");
	}

}

class RunThread implements Runnable {
	@Override
	public void run() {
		for (int iter = 0; iter < 20; iter++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("ERR: Interrupted");
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("ERR: Explicitly Unhandled");
				e.printStackTrace();
			}
			Thread currThread = Thread.currentThread();
			System.out.println(
					"Iter: " + iter + "\tName: " + currThread.getName() + "\tPriority: " + currThread.getPriority());
		}

	}
}

class ExtendThread extends Thread {
	@Override
	public void run() {
		for (int iter = 0; iter < 20; iter++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("ERR: Interrupted");
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("ERR: Explicitly Unhandled");
				e.printStackTrace();
			}
			Thread currThread = Thread.currentThread();
			System.out.println(
					"Iter: " + iter + "\tName: " + currThread.getName() + "\tPriority: " + currThread.getPriority());
		}

	}
}
