package com.java.Last_Time;

import com.start.java.person.PersonRepository;

public class Person_Client {

	public static void main(String[] args) {

		PersonDetails personDetails = new PersonDetailsImpl();
		double calculateTotalSalary = personDetails.calculateTotalSalary(PersonRepository.getAllPersons());
		System.out.println(calculateTotalSalary);

		System.out.println(personDetails.totalKids(PersonRepository.getAllPersons()));
	}

}
