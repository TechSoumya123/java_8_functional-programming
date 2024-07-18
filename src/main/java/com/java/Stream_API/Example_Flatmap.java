package com.java.Stream_API;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Flatmap {
	final static Logger logger = Logger.getLogger(Example_Flatmap.class.getName());

	public static void main(String[] args) {
		List<Integer> oddNumberList = Arrays.asList(1, 3, 5, 7);
		List<Integer> evenNumberList = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> lists = Arrays.asList(oddNumberList, evenNumberList);
		System.out.println(lists);

		lists.stream(); // Stream<List<Integer>> stream = lists.stream();

		List<Integer> list = lists.stream().flatMap(List::stream).toList();
		System.out.println(list);

		logger.info("---------------------------------------------");
		
		List<String> list2 = PersonRepository.getAllPersons()
		.stream()
		.map(Person::getHobbies)
		.flatMap(List::stream)
		.distinct()
		.sorted(Comparator.reverseOrder())
		.toList();
		System.out.println(list2);
		
		long count = PersonRepository.getAllPersons()
		.stream()
		.map(Person::getHobbies)
		.flatMap(List::stream)
		.distinct()
		.count();
		System.out.println(count);
		
		List<String> list3 = PersonRepository.getAllPersons()
		.stream()
		.sorted(Comparator.comparing(Person::getName))
		.map(Person::getName)
		.toList();
		System.out.println(list3);
		
		List<String> list4 = PersonRepository.getAllPersons()
		.stream()
		.sorted(Comparator.comparing(Person::getName).reversed())
		.map(Person::getName)
		.toList();
		System.out.println(list4);
		
		List<Integer> list5 = PersonRepository.getAllPersons()
		.stream()
		.sorted(Comparator.comparing(Person::getHeight).reversed())
		.map(Person::getHeight)
		.toList();
		System.out.println(list5);
	}

}
