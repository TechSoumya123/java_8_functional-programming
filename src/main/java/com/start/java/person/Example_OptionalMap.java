package com.start.java.person;

import java.util.Optional;

public class Example_OptionalMap {

	public static void main(String[] args) {

		optionalMapExample();
		System.out.println("------------------------------------");

		optionalFlatMapExample();
		System.out.println("------------------------------------");

		optionalMapFilterExample();

		System.out.println("------------------------------------");

		optionalFlatMapCustomExample();
	}

	private static void optionalMapExample() {
		Optional<Person> onePersonOptional = PersonRepository.getOnePersonOptional();
		onePersonOptional.ifPresent(per -> {
			String name = onePersonOptional.map(Person::getName).orElse("No Data Found");
			System.out.println(name);
		});
	}

	private static void optionalFlatMapExample() {
		Optional<Person> onePersonOptional = PersonRepository.getOnePersonOptional();
		onePersonOptional.ifPresent(per -> {
			Optional<Address> flatMap = onePersonOptional.flatMap(Person::getAddress);
			System.out.println(flatMap.get());
		});
	}

	private static void optionalMapFilterExample() {
		Optional<Person> onePersonOptional = PersonRepository.getOnePersonOptional();
		onePersonOptional.filter(per -> per.getHeight() >= 140)
				.ifPresent(person -> System.out.println(person.getAddress().get()));
	}

	private static void optionalFlatMapCustomExample() {
		Optional<Person> onePersonOptional = PersonRepository.getOnePersonOptional();
		onePersonOptional.flatMap(Person::getAddress).ifPresent(perAddress -> System.out.println(perAddress));
	}

}
