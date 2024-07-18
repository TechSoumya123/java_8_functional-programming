package com.java.code;

import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {

		Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x == y) ? 0 : 1);
		System.out.println(comparator.compare(12, 23));

		Comparator<Integer> comparator1 = (o1, o2) -> o1.compareTo(o2);
		System.out.println(comparator1.compare(10, 10));

	}

}
