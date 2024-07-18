package com.java.Stream_API;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class StreamVsCollection_Example {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Smith");
		names.add("Peter");

		names.stream().forEach(System.out::println);

		System.out.println("----------------");

		Stream<String> nameStream = names.stream();
		nameStream.forEach(System.out::println);

		nameStream.forEach(System.out::println);

		List<String> list = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.toList();
		System.out.println(list);
		
	
	}

}
