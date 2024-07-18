package com.java.BiPredicate_BiConsumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Person_BiPredicate_Example {

	final static Logger logger = Logger.getLogger(Person_BiPredicate_Example.class.getName());

	static BiPredicate<Integer, String> heightAndGenderBiPredicate = (height, gender) -> height >= 140
			&& gender.equals("Male");

	static BiConsumer<String, List<String>> nameAndHobbiesBiConsumer = (name, hobbies) -> System.out
			.println(name + " " + hobbies);

	static Consumer<Person> personConsumer = per -> {
		if (heightAndGenderBiPredicate.test(per.getHeight(), per.getGender())) {
			nameAndHobbiesBiConsumer.accept(per.getName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {
		List<Person> allPersons = PersonRepository.getAllPersons();
		allPersons.forEach(personConsumer);
	}

}
