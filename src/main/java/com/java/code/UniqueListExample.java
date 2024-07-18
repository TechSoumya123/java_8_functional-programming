package com.java.code;

import java.util.Arrays;
import java.util.List;

public class UniqueListExample {

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("John", "Peter", "Smith", "Ajay", "Smith");
		listOfStrings.stream().distinct().forEach(System.out::println);

	}

}
