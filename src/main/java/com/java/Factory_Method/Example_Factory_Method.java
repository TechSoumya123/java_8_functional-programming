package com.java.Factory_Method;

import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Example_Factory_Method {
	static UnaryOperator<Integer> addOperator = a -> a + 5;

	public static void main(String[] args) {

		Stream<Integer> s1 = Stream.iterate(0, addOperator);
//		s1.limit(100).forEach(System.out::println);

		System.out.println("------------------------------------------");

		List<Integer> list = s1.limit(100).toList().stream().filter(p -> p % 2 == 0).toList();
		System.out.println(list);

		Stream<Double> limit = Stream.generate(Math::random).limit(50);
		limit.forEach(System.out::println);

		Stream<Integer> limit2 = Stream.generate(new Random()::nextInt).limit(50);
		limit2.forEach(System.out::println);

	}

}
