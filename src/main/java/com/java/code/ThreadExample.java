package com.java.code;

import java.util.logging.Logger;

public class ThreadExample {

	final static Logger logger = Logger.getLogger(ThreadExample.class.getName());

	public static void main(String[] args) {

		Runnable thread1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread 1");
			}
		};
		new Thread(thread1).start();

		logger.info("---------------------------");

		Runnable thread2 = () -> System.out.println("Thread 2..");
		new Thread(thread2).run();

		logger.info("---------------------------");

		Runnable thread3 = () -> {
			System.out.println("Thread 3..");
			System.out.println("Thread 3.1..");
		};
		new Thread(thread3).start();

		logger.info("---------------------------");

		new Thread(() -> System.out.println("Thread 4..")).start();

		logger.info("---------------------------");

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread 5..");
			}
		}).start();
	}

}
