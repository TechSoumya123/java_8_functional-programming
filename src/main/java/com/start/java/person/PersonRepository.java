package com.start.java.person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

	private PersonRepository() {
	}

	public static List<Person> getAllPersons() {
		Person p1 = new Person("John", 165, 2000, "Male", 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
		Person p2 = new Person("Angel", 158, 5000, "Female", 2, Arrays.asList("Driving", "Music", "Football"));
		Person p3 = new Person("Dean", 140, 5700, "Male", 2, Arrays.asList("Cricket", "Driving", "Tennis"));
		Person p4 = new Person("Nancy", 130, 4900, "Female", 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
		Person p5 = new Person("Harper", 125, 9000, "Female", 2, Arrays.asList("Football", "Swimming", "Tennis"));
		Person p6 = new Person("Alan", 110, 9500, "Male", 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
		Person p7 = new Person("Campell", 165, 1548, "Male", 2, Arrays.asList("Swimming", "Tennis"));
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
	}

	public static Person getOnePerson() {
		return new Person("John", 165, 2000, "Male", 2, Arrays.asList("Cricket", "Swimming", "Tennis"));
	}

	public static Optional<Person> getOnePersonOptional() {
		Person person = getOnePerson();
		person.setAddress(Optional.of(new Address("7 th Block", "Kolkata", "West Bengal", "India", 700001)));
		return Optional.of(person);
	}

}
