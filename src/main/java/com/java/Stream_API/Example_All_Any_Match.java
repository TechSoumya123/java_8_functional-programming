package com.java.Stream_API;

import java.util.Arrays;
import java.util.List;

public class Example_All_Any_Match {

	public static void main(String[] args) {

		List<Integer> listOf_Numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		var allMatch = listOf_Numbers.stream().allMatch(num -> num % 2 == 0);// false
		System.out.println(allMatch);

		var anyMatch = listOf_Numbers.stream().anyMatch(num -> num % 2 == 0);// true
		System.out.println(anyMatch);

		var noneMatch = listOf_Numbers.stream().noneMatch(num -> num % 2 == 0);// false
		System.out.println(noneMatch);

		List<String> fruiList = Arrays.asList("Apple", "Orange", "Graphs", "Banana", "Pineapple");

		var allMatch2 = fruiList.stream().allMatch(fruit -> fruit.length() > 2);
		System.out.println(allMatch2);

	}

}
