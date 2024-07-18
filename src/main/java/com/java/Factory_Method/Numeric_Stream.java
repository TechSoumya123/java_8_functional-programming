package com.java.Factory_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Numeric_Stream {

	public static void main(String[] args) {

		IntStream.rangeClosed(1, 40).forEachOrdered(value -> System.out.println(value));

		IntStream.range(1, 40).forEach(value -> System.out.println(value));

		System.out.println("--------------------------------------------");

		System.out.println(IntStream.range(1, 10).reduce((left, right) -> left * right).getAsInt());

		// convert IntStream to DoubleStream

		DoubleStream asDoubleStream = IntStream.rangeClosed(1, 20).asDoubleStream();
		asDoubleStream.forEach(value -> System.out.println(value));

		System.out.println("---------------------");

		int sum = IntStream.rangeClosed(1, 50).sum();
		System.out.println(sum);

		System.out.println("---------------------");

		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		System.out.println(max.getAsInt());

		System.out.println("---------------------");
		List<Object> arrayList = IntStream.rangeClosed(1, 50).collect(ArrayList::new, List::add, List::addAll);
		System.out.println("ok.. " + arrayList);

		System.out.println("---------------------");
		OptionalInt min = IntStream.rangeClosed(1, 50).min();
		System.out.println(min.getAsInt());

		System.out.println("------ooooooo---------------");
		IntStream dropWhile = IntStream.rangeClosed(1, 50).dropWhile(value -> value < 30);
		dropWhile.forEach(System.out::println);

		System.out.println("------ooooooo---------------");
		IntStream takeWhile = IntStream.rangeClosed(1, 50).takeWhile(value -> value < 30);
		takeWhile.forEach(System.out::println);

	}

}
/*
 * 1 2 3 4 5 6 7 8 9 1+1=2 2+2=4 4+3=7 7+4=11 11+5=16 16+6=22 22+7=29 29+8=37
 * 37+9=46
 */
