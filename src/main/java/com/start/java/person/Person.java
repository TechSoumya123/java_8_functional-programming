package com.start.java.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {

	private String name;
	private int height;
	private double salary;
	private String gender;
	private int kids;
	private List<String> hobbies = new ArrayList<>();
	private Optional<Address> address;
	
	public Person(String name, int height, double salary, String gender, int kids, List<String> hobbies) {
		super();
		this.name = name;
		this.height = height;
		this.salary = salary;
		this.gender = gender;
		this.kids = kids;
		this.hobbies = hobbies;
	}
	
	
}
