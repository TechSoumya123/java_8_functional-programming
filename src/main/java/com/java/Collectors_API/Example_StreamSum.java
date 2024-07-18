package com.java.Collectors_API;

import java.util.stream.Collectors;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_StreamSum {

	public static void main(String[] args) {

		Integer collect = PersonRepository.getAllPersons().stream()
				.collect(Collectors.filtering(per -> per.getHeight() >= 140, Collectors.summingInt(Person::getKids)));
		System.out.println(collect);

		Integer collect2 = PersonRepository.getAllPersons().stream().collect(Collectors.summingInt(Person::getKids));
		System.out.println(collect2);

		Double collect3 = PersonRepository.getAllPersons().stream().collect(Collectors.averagingInt(Person::getHeight));
		System.out.println(collect3);

		
	}

}
