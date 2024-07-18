package com.java.Stream_API;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Reduce {

	final static Logger logger = Logger.getLogger(Example_Reduce.class.getName());

	public static void main(String[] args) {

		List<Integer> listOf_Numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		try {
			Optional<Integer> reduce = listOf_Numbers.stream().reduce((o1, o2) -> o1 + o2);
			System.out.println(reduce.orElseGet(() -> Integer.valueOf("If no value present then sum: " + (9 + 9))));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		long count = listOf_Numbers.stream().map(o -> o).count();
		System.out.println(count);

		Integer reduce = listOf_Numbers.stream().reduce(1, (o1, o2) -> o1 * o2);
		System.out.println(reduce);

		Integer reduce2 = listOf_Numbers.stream().reduce(0, Integer::sum);
		System.out.println(reduce2);

		logger.info(() -> "---------------------------------------------");

		String reduce3 = PersonRepository.getAllPersons().stream().map(Person::getName).reduce("",
				(a, b) -> a + " " + b);
		System.out.println(reduce3);

		String reduce4 = PersonRepository.getAllPersons().stream().map(Person::getName).reduce("",
				(a, b) -> a.concat(" " + b));
		System.out.println(reduce4);

		Optional<Person> reduce5 = PersonRepository.getAllPersons().stream()
				.reduce((p1, p2) -> p1.getHeight() > p2.getHeight() ? p1 : p2);
		System.out.println(reduce5.get());

		int reduce6 = PersonRepository.getAllPersons().stream()
				.filter(per -> per.getHeight() >= 140)
				.map(Person::getKids)
				.reduce(0, Integer::sum);
		System.out.println(reduce6);

	}

}
