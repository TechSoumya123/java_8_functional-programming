package com.java.Collectors_API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Grouping {

	final static Logger logger = Logger.getLogger(Example_Grouping.class.getName());

	public static void main(String[] args) {

		Map<String, List<Person>> collect = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getGender));

		collect.entrySet().forEach(System.out::println);

//		Stream.of(collect).forEach(System.out::println);

		logger.info("-----------------------------------------");

		Map<String, List<Person>> collect2 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(per -> per.getHeight() >= 140 ? "Tallest" : "shortest"));

		collect2.entrySet().forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<String, Map<String, List<Person>>> collect3 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getGender,
						Collectors.groupingBy(per -> per.getHeight() >= 140 ? "Tallest" : "shortest")));
		Stream.of(collect3).forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<String, Map<String, Set<Person>>> collect4 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors
						.groupingBy(per -> per.getHeight() >= 140 ? "Tallest" : "shortest", Collectors.toSet())));
		Stream.of(collect4).forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<String, Map<String, Long>> collect5 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors
						.groupingBy(per -> per.getHeight() >= 140 ? "Tallest" : "shortest", Collectors.counting())));

		Stream.of(collect5).forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<String, Integer> collect6 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getKids)));
		Stream.of(collect6).forEach(System.out::println);

		logger.info("------------------------------------------------");

		HashMap<String, List<Person>> collect7 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.groupingBy(Person::getName, HashMap::new, Collectors.toList()));

		Stream.of(collect7).forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<Boolean, List<Person>> collect8 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.partitioningBy(per -> per.getGender().equalsIgnoreCase("Male")));

		collect8.entrySet().forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<Boolean, Set<Person>> collect9 = PersonRepository.getAllPersons().stream().collect(
				Collectors.partitioningBy(per -> per.getGender().equalsIgnoreCase("Male"), Collectors.toSet()));
		collect9.entrySet().forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<Boolean, Map<Integer, String>> collect10 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.partitioningBy(per -> per.getGender().equalsIgnoreCase("Male"),
						Collectors.toMap(Person::getHeight, p -> p.getName(), (o, n) -> n)));

		Stream.of(collect10).forEach(System.out::println);

		logger.info("------------------------------------------------");

		Map<Boolean, Map<String, Long>> collect11 = PersonRepository.getAllPersons().stream()
				.collect(Collectors.partitioningBy(per -> per.getGender().equalsIgnoreCase("Male"), Collectors
						.groupingBy(per -> per.getHeight() >= 140 ? "Tallest" : "shortest", Collectors.counting())));
		Stream.of(collect11).forEach(System.out::println);
		
		logger.info("------------------------------------------------");

	 Map<Boolean,Map<String,List<String>>> collect12 = PersonRepository.getAllPersons().stream()
				.collect(
						Collectors.partitioningBy(
								per -> per.getGender().equalsIgnoreCase("Male"),Collectors.toMap(Person::getName, Person::getHobbies))
						);
					
		Stream.of(collect12).forEach(System.out::println);

	}

}
