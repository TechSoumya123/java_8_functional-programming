package com.java.Stream_API;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Max_Min_By {

	final static Logger logger = Logger.getLogger(Example_Max_Min_By.class.getName());

	static List<Person> LISTOF_PERSONS = PersonRepository.getAllPersons();
	static Optional<Person> maxHeightOptional = LISTOF_PERSONS.stream().max(Comparator.comparing(Person::getHeight));

	static Optional<Person> minHeightOptional = LISTOF_PERSONS.stream().min(Comparator.comparing(Person::getHeight));

	static List<Person> getMultiplePerson() {
		List<Person> addPersonsHere = new ArrayList<>();
		Person tallestPerson = maxHeightOptional.isPresent() ? maxHeightOptional.get() : null;
		if (tallestPerson != null) {
			addPersonsHere = PersonRepository.getAllPersons().stream()
					.filter(per -> per.getHeight() == tallestPerson.getHeight()).toList();
		}
		return addPersonsHere;
	}

	public static void main(String[] args) {

		System.out.println(maxHeightOptional.get());

		System.out.println(minHeightOptional.get());
		
		logger.info("--------------------------------------------------");
		
		getMultiplePerson().forEach(System.out::println);
	}

}
