package com.java.BinaryOperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Example_BinaryOperator {

	static Comparator<Integer> comparator = (t1, t2) -> t1.compareTo(t2);

	public static void main(String[] args) {

		BinaryOperator<Integer> binaryOperator = (a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1;
		System.out.println(binaryOperator.apply(20, 100));

		BinaryOperator<Integer> binaryOperator2 = BinaryOperator.maxBy((o1, o2) -> o1.compareTo(o2));
		System.out.println(binaryOperator2.apply(20, 100));

		BinaryOperator<Integer> binaryOperator3 = BinaryOperator.maxBy(comparator);
		System.out.println(binaryOperator3.apply(200, 100));

		BinaryOperator<Integer> binaryOperator4 = BinaryOperator.minBy((o1, o2) -> o1.compareTo(o2));
		System.out.println(binaryOperator4.apply(20, 100));

		BinaryOperator<Integer> binaryOperator5 = BinaryOperator.minBy(comparator);
		System.out.println(binaryOperator5.apply(200, 100));

	}

}
