package com.java.Bi_Consumer;

import java.util.List;
import java.util.function.BiConsumer;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Person_BiConsumer_Example {

	static List<Person> LISTOF_PERSONS = PersonRepository.getAllPersons();

	static void nameAndHobbies() {
		
		BiConsumer<String, List<String>> nameAndHobbiesBiConsumer = (name, hobbies) -> System.out
				.println(name + " " + hobbies);

		BiConsumer<String, Double> nameAndSalaryBiConsumer = (name, salary) -> System.out
				.println(name + " = " + salary);

		LISTOF_PERSONS.forEach(per -> {
			nameAndHobbiesBiConsumer.accept(per.getName(), per.getHobbies());
			nameAndSalaryBiConsumer.accept(per.getName(), per.getSalary());
		});
	}

	public static void main(String[] args) {
		nameAndHobbies();
	}

}
