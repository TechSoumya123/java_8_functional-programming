package com.java.code;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class SumExample {

	final static Logger logger = Logger.getLogger(SumExample.class.getName());

	public static void main(String[] args) {

		int sum = IntStream.rangeClosed(1, 50).boxed().mapToInt(e -> e).sum();
		System.out.println(sum);

		int sum1 = IntStream.rangeClosed(1, 50).map(e -> e).sum();
		System.out.println(sum1);

		int sum2 = IntStream.rangeClosed(1, 50).reduce(0, Integer::sum);
		System.out.println(sum2);

	}

}
