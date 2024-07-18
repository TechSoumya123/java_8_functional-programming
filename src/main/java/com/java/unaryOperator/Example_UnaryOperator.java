package com.java.unaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Example_UnaryOperator {

	public static void main(String[] args) {
		BiPredicate<Integer, String> heightAndGenderBiPredicate = (height, gender) -> height >= 140
				&& gender.equalsIgnoreCase("Male");

		List<Person> pList = new ArrayList<>();

		UnaryOperator<List<Person>> personUnaryOperator = person_data -> {
			person_data.forEach(per -> {
				if (heightAndGenderBiPredicate.test(per.getHeight(), per.getGender()))
					pList.add(per);
			});
			return pList;
		};
		personUnaryOperator.apply(PersonRepository.getAllPersons()).stream().forEach(System.out::println);

	}

}
