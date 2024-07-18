package com.java.Predicate;

import java.util.function.Predicate;
import java.util.logging.Logger;

public class Predicate_Example {

	final static Logger logger = Logger.getLogger(Predicate_Example.class.getName());

	public static void main(String[] args) {

		Predicate<Integer> lessThanCheck = t -> (t <= 50);
		System.out.println(lessThanCheck.test(40));

		logger.info(() -> "-----------------------------------------------");

		Predicate<Integer> graterThanCheck = t -> (t >= 50);
		System.out.println(graterThanCheck.test(200));

		logger.info(() -> "-----------------------------------------------");

		Predicate<Integer> equalCheck = t -> (t == 50);
		System.out.println(equalCheck.test(200));

		logger.info(() -> "-----------------------------------------------");

		System.out.println(lessThanCheck.and(graterThanCheck).and(equalCheck).test(80));

		System.out.println(lessThanCheck.or(graterThanCheck).or(equalCheck).test(80));

		System.out.println(lessThanCheck.or(graterThanCheck).or(equalCheck).negate().test(80));

	}

}
