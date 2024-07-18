package com.java.Method_Reference;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class ExampleOf_MethodReferences {

	static Comparator<Integer> compare = ExampleOf_MethodReferences::compareTo;

	static Function<String, String> toUpperCaseFunction = t -> t.toUpperCase();
	static Function<String, String> toUpperCaseFunction2 = String::toUpperCase;

	static Predicate<Person> heightCheckPredicate = ExampleOf_MethodReferences::heightCheckMethod;

	static BiPredicate<Person, Integer> heightCheckPredicateRunTimeValuePass = ExampleOf_MethodReferences::heightCheckMethodRunTimeValuePass;

	public static void main(String[] args) {

		System.out.println(compare.compare(10, 90));

		System.out.println(toUpperCaseFunction.apply("Soumya"));

		System.out.println(toUpperCaseFunction2.apply("Soumya"));

		System.out.println(heightCheckPredicate.test(PersonRepository.getOnePerson()));

		System.out.println(heightCheckPredicateRunTimeValuePass.test(PersonRepository.getOnePerson(), 145));

	}

	public static int compareTo(Integer a, Integer b) {
		return Integer.compare(12, 20);
	}

	public static boolean heightCheckMethod(Person person) {
		return person.getHeight() >= 140;
	}

	public static boolean heightCheckMethodRunTimeValuePass(Person person, Integer height) {
		return person.getHeight() >= height;
	}
}
