package com.java.Boxing_UnBoxing;

import java.util.stream.IntStream;

public class Example_Check {

	static double map_Double() {
		return IntStream.rangeClosed(1, 10).mapToDouble(value -> value).sum();
	}

	public static void main(String[] args) {
		System.out.println(map_Double());
	}

}
