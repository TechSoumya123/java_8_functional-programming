package com.java.Default_Method;

import java.util.Comparator;
import java.util.List;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Default_Custom_Sort {

	static Comparator<Person> basedOnName = Comparator.comparing(Person::getName);

	static Comparator<Person> basedOnHeight = Comparator.comparing(Person::getHeight);

	public static void main(String[] args) {

		List<Person> allPersons = PersonRepository.getAllPersons();

//		allPersons.stream().sorted(Comparator.comparing(Person::getName))
//				.collect(Collectors.toList());

//		allPersons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getHeight));

//		allPersons.forEach(System.out::println);

		Comparator<Person> ok = Comparator.nullsFirst(basedOnName);

		allPersons.sort(ok);

		allPersons.forEach(per -> System.out.println(per));

		System.out.println("------------------------------");

		Comparator<Person> nullsLast = Comparator.nullsLast(basedOnHeight);

		allPersons.sort(nullsLast);
		allPersons.forEach(System.out::println);

	}

}
