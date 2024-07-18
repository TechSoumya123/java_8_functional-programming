package com.java.Last_Time;

import java.util.List;

import com.start.java.person.Person;

public class PersonDetailsImpl implements PersonDetails {

	@Override
	public double calculateTotalSalary(List<Person> persons) {
		
		return persons
				.stream()
				.mapToDouble(Person::getSalary)
				.reduce(0, (a,b)->a+b);
	}

}
