package com.java.Stream_API;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Person_Stream_API_Example {

	final static Logger logger = Logger.getLogger(Person_Stream_API_Example.class.getName());

	static Supplier<List<Person>> personList = PersonRepository::getAllPersons;

	static Predicate<Person> heightPredicate = person -> person.getHeight() >= 140;
	static Predicate<Person> genderPredicate = person -> person.getGender().equalsIgnoreCase("Male");

	public static void main(String[] args) {

		personList.get().stream().filter(heightPredicate.and(genderPredicate))
				.collect(Collectors.toMap(Person::getName, Person::getHobbies)).entrySet().stream()
				.forEach(s -> System.out.println(s.getKey() + " = " + s.getValue()));

		logger.info(() -> "------------------------------------------------------");

		List<String> list = personList.get().stream().map(Person::getHobbies).flatMap(List::stream).distinct().toList();
		System.out.println(list);

	}

}
