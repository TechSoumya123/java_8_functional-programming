package com.java.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Person_predicate_Example {

	final static Logger logger = Logger.getLogger(Person_predicate_Example.class.getName());

	static Predicate<Person> predicate = t -> t.getHeight() >= 140;

	static Predicate<Person> predicate1 = t -> t.getGender().equals("Male");

	static List<Person> allPersons = PersonRepository.getAllPersons();

	public static void main(String[] args) {

		allPersons.stream().filter(predicate.and(predicate1)).toList().forEach(System.out::println);
		logger.info(() -> "-------------------------------------------------");

		allPersons.forEach(per -> {
			if (predicate.and(predicate1).test(per)) {
				System.out.println(per);
			}
		});
	}

}
