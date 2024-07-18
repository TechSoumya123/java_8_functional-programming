package com.java.Function_ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Function_Person_Example {

	final static Logger logger = Logger.getLogger(Function_Person_Example.class.getName());

	static Predicate<Person> HEIGHT_PREDICATE = person -> person.getHeight() >= 140;

	static Predicate<Person> GENDER_PREDICATE = per -> per.getGender().equals("Male");

	static BiPredicate<Integer, String> HEIGHT_GENDER_PREDICATE = (height, gender) -> height >= 140
			&& gender.equals("Male");

	static Function<List<Person>, Map<String, Double>> nameAndSalaryFunction = listOf_Person -> {
		Map<String, Double> checkMap = new HashMap<>();
		listOf_Person.forEach(per -> {
			if (HEIGHT_PREDICATE.and(GENDER_PREDICATE).test(per)) {
				checkMap.put(per.getName(), per.getSalary());
			}
		});
		return checkMap;
	};

	static Function<List<Person>, Map<String, List<String>>> nameAndHobbiesFunction = person1 -> {
		Map<String, List<String>> okNameAndHobbiesMap = new HashMap<>();
		person1.forEach(per -> {
			if (HEIGHT_GENDER_PREDICATE.test(per.getHeight(), per.getGender())) {
				okNameAndHobbiesMap.put(per.getName(), per.getHobbies());
			}
		});
		return okNameAndHobbiesMap;
	};

	public static void main(String[] args) {

		System.out.println(nameAndSalaryFunction.apply(PersonRepository.getAllPersons()));
		
		logger.info(() -> "------------------------------------------");
		
		System.out.println(nameAndHobbiesFunction.apply(PersonRepository.getAllPersons()));
	}

}
