package com.java.Parallel;

import java.util.List;
import java.util.stream.IntStream;

public class Parallel_take_Time {

	public static void main(String[] args) {

		List<Integer> list = IntStream
				.rangeClosed(1, 10000)
				.boxed()
				.toList();
		
		sequentialCalculation(list);
		
		System.out.println("-------------------------------------------------");
		
		parallelCalculation(list);
	}

	static int sequentialCalculation(List<Integer> list) {
		long start = System
				.currentTimeMillis();
		
		int total = list
				.stream()
				.reduce(0, (a, b) -> a + b);
		long end = System
				.currentTimeMillis();
		
		System.out.println(end - start);
		return total;
	}

	static int parallelCalculation(List<Integer> list) {
		long start = System
				.currentTimeMillis();
		
		int total = list
				.parallelStream()
				.reduce(0, (a, b) -> a + b);
		
		long end = System
				.currentTimeMillis();
		
		System.out.println(end - start);
		return total;
	}

}
