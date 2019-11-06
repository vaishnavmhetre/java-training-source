/**
 * 
 */
package com.thread;

/**
 * @author Allianz3076
 *
 */
class ProducerConsumer {

	protected String message;
	protected boolean hasMessage;

	public synchronized void putMessage(String message) {
		while (hasMessage) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("ERR: putMessage Interrupted");
			}
		}
		this.message = message + " Put @ " + System.nanoTime();
		hasMessage = true;
		notify();
	}
	
	public synchronized String getMessage() {
		while(!hasMessage) {
			try {
				wait();
			} catch(InterruptedException e) {
				System.err.println("ERR: getMessage Interrupted");
			}
		}
		hasMessage = false;
		notify();
		return message + " Get @ " + System.nanoTime();
	}

}

public class ThreadProducerConsumer{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ProducerConsumer box = new ProducerConsumer();
		
		Thread productThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Producer thread started...");
				for (int iter = 0; iter < 6; iter++) {
					box.putMessage("message " + iter);
					System.out.println("Put message " + iter);
				}
			}
		};
		
		Thread consumerThread1 = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer 1 thread started...");
				for (int iter = 0; iter < 6; iter++) {
					System.out.println("Consumer thread 1 get " + box.getMessage() + iter);
				}
			}
		};
		

		Thread consumerThread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer 2 thread started...");
				for (int iter = 0; iter < 6; iter++) {
					System.out.println("Consumer thread 2 get " + box.getMessage() + iter);
				}
			}
		};
		
		consumerThread1.start();
		consumerThread2.start();
		productThread.start();
	}
}
