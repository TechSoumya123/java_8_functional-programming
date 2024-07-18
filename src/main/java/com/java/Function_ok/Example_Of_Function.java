package com.java.Function_ok;

import java.util.function.Function;
import java.util.logging.Logger;

public class Example_Of_Function {

	final static Logger logger = Logger.getLogger(Example_Of_Function.class.getName());

	public static void main(String[] args) {
		Function<Integer, Integer> sumAndReturnInteger = t -> t + 2;
		System.out.println(sumAndReturnInteger.apply(10));

		logger.info(() -> "-------------------------------------------");

		Function<String, Integer> lengthReturn = t -> t.length();
		System.out.println(lengthReturn.apply("Soumya"));

		logger.info(() -> "-------------------------------------------");

		Function<String, String> toUpperCaseFunction = u -> u.toUpperCase();

		Function<String, String> toUpperCaseFunction1 = u -> u.toUpperCase().concat(" Feature");

		System.out.println("AndThen : " + toUpperCaseFunction.andThen(toUpperCaseFunction1).apply("Java"));

		System.out.println("Compose : " + toUpperCaseFunction.compose(toUpperCaseFunction1).apply("Java"));
	}

}
