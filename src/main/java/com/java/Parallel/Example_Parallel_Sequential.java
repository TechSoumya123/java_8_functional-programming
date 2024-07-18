package com.java.Parallel;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class Example_Parallel_Sequential {

	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());

		System.out.println("---------------------------------------");
		String[] array = { "one", "two", "one", "two", "one", "two", "one", "two", "one", "two", "one", "two", "one",
				"two", "one", "two", "one", "two", "one", "two" };
		printAllStream(Arrays.stream(array).sequential());

		System.out.println("---------------------------------------");

		printAllStream(Arrays.stream(array).parallel());

	}

	static void printAllStream(Stream<String> stream) {
		stream.forEach(o -> {
			System.out.println(LocalTime.now() + " Value " + o + " - thread : " + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
