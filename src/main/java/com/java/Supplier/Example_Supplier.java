package com.java.Supplier;

import java.util.List;
import java.util.function.Supplier;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Supplier {

	static Supplier<List<Person>> allPerson = PersonRepository::getAllPersons;

	public static void main(String[] args) {
		allPerson.get().forEach(System.out::println);
	}

}
