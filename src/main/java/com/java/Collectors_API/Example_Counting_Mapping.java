package com.java.Collectors_API;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Counting_Mapping {

	final static Logger logger = Logger.getLogger(Example_Counting_Mapping.class.getName());

	static Predicate<Person> heighPredicate = per -> per.getHeight() >= 140;
	static Predicate<Person> genderPredicate = per -> per.getGender().equals("Male");

	public static void main(String[] args) {

		LinkedList<String> collect = PersonRepository.getAllPersons().stream()
				.collect(Collectors.mapping(Person::getName, Collectors.toCollection(LinkedList::new)));
		System.out.println(collect);

		logger.info(() -> "------------------------------");

		Map<String, Integer> collect2 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getKids)));
		System.out.println(collect2);

		logger.info(() -> "------------------------------");

		Integer collect3 = PersonRepository.getAllPersons().stream().collect(Collectors.summingInt(Person::getKids));
		System.out.println(collect3);

		Set<Person> collect4 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), r -> r));
		System.out.println(collect4);

		System.out.println("---------------------------------------------");

		Map<String, Set<Person>> collect5 = PersonRepository.getAllPersons().stream().collect(
				Collectors.groupingBy(Person::getName, Collectors.filtering(heighPredicate, Collectors.toSet())));
		collect5.entrySet().stream().forEach(System.out::println);

		System.out.println("------------------------------------------");

		List<Person> collect6 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.filtering(per -> per.getHeight() >= 140, Collectors.toList()));
		collect6.forEach(System.out::println);

		System.out.println("------------------------------------------");

		Map<String, List<String>> collect7 = PersonRepository.getAllPersons().stream().collect(Collectors
				.filtering(heighPredicate.and(genderPredicate), Collectors.toMap(Person::getName, Person::getHobbies)));
		collect7.entrySet().forEach(System.out::println);

		System.out.println("-------------------------");

		Map<String, List<String>> collect8 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.filtering(per -> per.getHeight() >= 140 && per.getGender().equalsIgnoreCase("Male"),
						Collectors.toMap(Person::getName, Person::getHobbies)));
		collect8.entrySet().forEach(System.out::println);

	}

}
