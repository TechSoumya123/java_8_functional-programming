package com.java.Last_Time;

import java.util.List;

import com.start.java.person.Person;

public interface PersonDetails {

	double calculateTotalSalary(List<Person> persons);
	
	default int totalKids(List<Person> persons) {
		return persons.stream().map(Person::getKids).reduce(0, Integer::sum);
	}
}
