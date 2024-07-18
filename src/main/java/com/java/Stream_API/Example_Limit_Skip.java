package com.java.Stream_API;

import java.util.Arrays;
import java.util.List;

public class Example_Limit_Skip {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");

		List<String> limit = fruits
				.stream()
				.limit(3)
				.toList();
		System.out.println(limit);

		List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		int sum = numbersList
				.stream()
				.limit(5)
				.mapToInt(o -> o)
				.sum();
		System.out.println(sum);
		
		Integer reduce = numbersList.stream()
		.skip(5)
		.reduce(0,(a,b)->a+b);
		System.out.println(reduce);
	}

}
