package com.java.Consumer;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class PersonConsumer_Example {

	final static Logger logger = Logger.getLogger(PersonConsumer_Example.class.getName());

	static Consumer<Person> consumer1 = t -> System.out.println(t);

	static Consumer<Person> consumer2 = t -> System.out.println(t.getName().toUpperCase());

	static Consumer<Person> consumer3 = t -> System.out.println(t.getHobbies());

	static List<Person> allPersons = PersonRepository.getAllPersons();

	static void printAllInformation() {
		for (Person person : allPersons) {
			consumer1.andThen(consumer2).andThen(consumer3).accept(person);
			logger.info(() -> "--- --- --- " + String.valueOf(person.getName()) + "--- --- --- --- --- --- --- ");
		}
	}

	static void printWithCondition() {
		allPersons.forEach(p -> {
			if (p.getGender().equalsIgnoreCase("Male") && p.getHeight() >= 140) {
				consumer2.andThen(consumer3).accept(p);
			}
		});
	}

	public static void main(String[] args) {

//		TODO -1
		consumer1.accept(PersonRepository.getOnePerson());
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -2
		consumer2.accept(PersonRepository.getOnePerson());
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -3
		consumer3.accept(PersonRepository.getOnePerson());
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -4
		consumer1.andThen(consumer2).andThen(consumer3).accept(PersonRepository.getOnePerson());
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -5
		printAllInformation();
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -6
		printWithCondition();
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -7
		allPersons.forEach(consumer1);
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -8
		allPersons.forEach(consumer2);
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

//		TODO -9
		allPersons.forEach(consumer3);
		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

	}

}
