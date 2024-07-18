package com.java.Stream_API;

import java.util.Optional;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Find_First_Any {

	public static void main(String[] args) {

//		Optional<Person> findFirst = PersonRepository.getAllPersons().stream()
//				.filter(person -> person.getHeight() >= 140 && person.getGender().equalsIgnoreCase("Male")).findFirst();
//		System.out.println(findFirst.get());

		for (int i = 0; i < 100; i++) {
			Optional<Person> findAny = PersonRepository
					.getAllPersons()
					.parallelStream()
					.filter(person -> person.getHeight() >= 140 && person.getGender().equalsIgnoreCase("Male"))
					.findAny();
			System.out.println(findAny.get());
		}
		System.out.println("---------------------------------------------------");
		for (int i = 0; i < 100; i++) {
			Optional<Person> findAny1 = PersonRepository
					.getAllPersons()
					.stream()
					.filter(person -> person.getHeight() >= 140 && person.getGender().equalsIgnoreCase("Male"))
					.findAny();
			System.out.println(findAny1.get());
		}

	}

}
