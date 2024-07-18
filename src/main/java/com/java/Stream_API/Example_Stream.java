package com.java.Stream_API;

import java.util.stream.Stream;

public class Example_Stream {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		stream.forEach(System.out::println);

		Stream<Integer> fromArrayStream = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		fromArrayStream.forEach(System.out::println);
		
		
	}

}
