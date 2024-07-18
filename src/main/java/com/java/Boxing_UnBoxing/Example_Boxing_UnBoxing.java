package com.java.Boxing_UnBoxing;

import java.util.List;
import java.util.stream.IntStream;

public class Example_Boxing_UnBoxing {

	static List<Integer> boxingMethod() {
		return IntStream.rangeClosed(1, 50)// Primitive int
				.boxed() // wrapper Integer
				.toList(); // toList
	}

	static int unBoxingMethod(List<Integer> listOf) {
		return listOf
				.stream()
				.mapToInt(e -> e)
				.sum();
	}

	public static void main(String[] args) {

		boxingMethod().forEach(System.out::println);

		System.out.println(unBoxingMethod(boxingMethod()));
	}

}
