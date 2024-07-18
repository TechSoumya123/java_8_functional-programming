package com.java.Consumer_Predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Consumer_Predicate_Example {

	final static Logger logger = Logger.getLogger(Consumer_Predicate_Example.class.getName());

	static Predicate<Person> predicate = t -> t.getHeight() >= 140;

	static Predicate<Person> predicate1 = t1 -> t1.getGender().equals("Male");

	static BiConsumer<String, List<String>> nameAndHobbiesBiConsumer = (name, hobbies) -> System.out
			.println(name + " " + hobbies);

	static Consumer<Person> perConsumer = per -> {
		if (predicate.and(predicate1).test(per)) {
			nameAndHobbiesBiConsumer.accept(per.getName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {

	List<Person> listOf_Persons = PersonRepository.getAllPersons();
	listOf_Persons.forEach(perConsumer);
	}

}
