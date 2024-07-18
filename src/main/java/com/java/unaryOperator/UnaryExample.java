package com.java.unaryOperator;

import java.util.function.UnaryOperator;

public class UnaryExample {

	static UnaryOperator<String> unaryOperator = t -> t.toUpperCase();
	static UnaryOperator<Integer> unaryOperator1 = t -> t + 10;

	public static void main(String[] args) {

		System.out.println(unaryOperator.apply("java features"));
		System.out.println(unaryOperator1.apply(90));
	}

}
