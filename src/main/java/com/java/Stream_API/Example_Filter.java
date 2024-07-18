package com.java.Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Filter {

	final static Logger logger = Logger.getLogger(Example_Filter.class.getName());

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Nancy", "John", "Sam", "Anderson", "Bimal");
		List<String> list = names.stream().filter(name -> name.length() > 3).toList();
		System.out.println(list);

		logger.info(() -> "-----------------------------------------");

		List<Person> list2 = PersonRepository.getAllPersons().stream()
				.filter(person -> person.getHeight() >= 140 && person.getGender().equals("Male")).toList();

		list2.forEach(System.out::println);

	}

}
