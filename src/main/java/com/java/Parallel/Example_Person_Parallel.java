package com.java.Parallel;

import java.util.List;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_Person_Parallel {

	public static void main(String[] args) {

		System.out.println(getHobbies());
		
		System.out.println(getHobbiesParallel());
		
	}

	static List<String> getHobbies() {
		long start=System.currentTimeMillis();
		List<String> hobbies = PersonRepository
				.getAllPersons()
				.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.toList();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		return hobbies;
	}
	
	static List<String> getHobbiesParallel() {
		long start=System.currentTimeMillis();
		List<String> hobbies = PersonRepository
				.getAllPersons()
				.parallelStream()
				.map(Person::getHobbies)
				.flatMap(List::parallelStream)
				.toList();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		return hobbies;
	}

}
