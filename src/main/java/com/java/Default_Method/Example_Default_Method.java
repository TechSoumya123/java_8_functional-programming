package com.java.Default_Method;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Default_Method {

	final static Logger logger = Logger.getLogger(Example_Default_Method.class.getName());

	public static void main(String[] args) {
		List<String> list = PersonRepository.getAllPersons().stream().map(Person::getName).collect(Collectors.toList());

		System.out.println("Before sort : " + list);

		logger.info("-----------------------------------------------------");

		Collections.sort(list);

		System.out.println("After sort : " + list);

		logger.info("-----------------------------------------------------");

		Collections.sort(list, Comparator.reverseOrder());

		System.out.println("After reversing : " + list);

		logger.info("-----------------------------------------------------");

		list.sort(Comparator.naturalOrder());

		System.out.println("naturalOrder : " + list);

		logger.info("-----------------------------------------------------");

		
		
		
		PersonRepository.getAllPersons().stream().sorted(Comparator.comparing(Person::getName)).toList();
	}

}
