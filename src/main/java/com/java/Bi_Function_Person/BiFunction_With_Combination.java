package com.java.Bi_Function_Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.logging.Logger;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class BiFunction_With_Combination {

	final static Logger logger = Logger.getLogger(BiFunction_With_Combination.class.getName());

	static List<Person> allPersons = PersonRepository.getAllPersons();

	static Predicate<Person> heightCheckPredicate = height -> height.getHeight() >= 140;

	static Predicate<Person> genderCheckPredicate = gender -> gender.getGender().equalsIgnoreCase("Male");

	static BiPredicate<Integer, String> heightAndGendeBiPredicate = (height, gender) -> height >= 140
			&& gender.equalsIgnoreCase("Male");

	static BiFunction<List<Person>, BiPredicate<Integer, String>, Map<String, List<String>>> nameAndHobbiesBiFunction = (
			personList, condtion) -> {
		Map<String, List<String>> plzReturnMap = new HashMap<>();
		personList.forEach(per -> {
			if (condtion.test(per.getHeight(), per.getGender())) {
				plzReturnMap.put(per.getName(), per.getHobbies());
			}
		});
		return plzReturnMap;
	};

	static BiFunction<List<Person>, Predicate<Person>, Map<String, List<String>>> nameAndHobbiesBiFunction1 = (
			personAll, condition1) -> {
		Map<String, List<String>> plzReturnMap2 = new HashMap<>();
		personAll.forEach(per -> {
			if (condition1.and(genderCheckPredicate).test(per)) {
				plzReturnMap2.put(per.getName(), per.getHobbies());
			}
		});

		return plzReturnMap2;
	};

	public static void main(String[] args) {
		System.out.println(nameAndHobbiesBiFunction.apply(allPersons, heightAndGendeBiPredicate));

		nameAndHobbiesBiFunction1.apply(allPersons, heightCheckPredicate);
	}

}
