package com.java.Collectors_API;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Joining {

	final static Logger logger = Logger.getLogger(Example_Joining.class.getName());

	public static void main(String[] args) {

		char[] ch = { 'a', 'b', 'c', 'd' };
		String collect = Stream.of(ch).map(array -> new String(array)).collect(Collectors.joining());
		System.out.println(collect);

		logger.info("--------------------------------------------------");

		String collect2 = Stream.of(ch).map(String::valueOf).collect(Collectors.joining("--","{","}"));
		System.out.println(collect2);
		
		String collect3 = PersonRepository.getAllPersons()
		.stream()
		.map(Person::getName)
		.collect(Collectors.joining(","));
		System.out.println(collect3);
	}

}
