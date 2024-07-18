package com.java.Optional;

import java.util.Optional;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Optional {

	final static Logger logger = Logger.getLogger(Example_Optional.class.getName());

	public static void main(String[] args) {

		System.out.println(anyName("ok"));

		logger.info("--------------------------------------");

//		Optional<String> nameOptional = Optional.ofNullable(anyName(null));
//		System.out.println(nameOptional.isPresent() ? nameOptional.get() : nameOptional);

		logger.info(() -> "------------------------------------");

		System.out.println(getOnePerson(new Person()));

		logger.info(() -> "------------------------------------");

		Optional<String> optional = nameOptional(PersonRepository.getOnePersonOptional());
		System.out.println(optional.get());

	}

	static String anyName(String name) {
		return name;
	}

	static String getOnePerson(Person per) {
		if (per != null) {
			return per.getName();
		} else {
			return "No Data Found..";
		}
	}

	static Optional<String> nameOptional(Optional<Person> person) {
		if (person != null) {
			return Optional.of(person.get().getName());
		} else {
			return Optional.empty();
		}
	}

}
