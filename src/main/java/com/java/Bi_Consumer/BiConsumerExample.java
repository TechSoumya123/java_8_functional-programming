package com.java.Bi_Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class BiConsumerExample {

	final static Logger logger = Logger.getLogger(BiConsumerExample.class.getName());

	public static void main(String[] args) {

		BiConsumer<Integer, Integer> additionBiConsumer = (a, b) -> System.out
				.println("additionBiConsumer Example : " + (a + b));
		additionBiConsumer.accept(12, 20);

		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- --- ---");

		List<Integer> list1 = Arrays.asList(12, 23, 45);
		List<Integer> list2 = Arrays.asList(90, 87);

		BiConsumer<List<Integer>, List<Integer>> sizeBiConsumer = (l1, l2) -> {
			if (l1.size() == l2.size()) {
				System.out.println("l1 And l2 size is equal : " + true);
			} else {
				System.out.println("l1 And l2 size is not equal : " + false);
			}
		};
		sizeBiConsumer.accept(list1, list2);

		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- --- ---");

		BiConsumer<Integer, Integer> multiplicationBiConsumer = (a, b) -> System.out
				.println("MultiplicationBiConsumer Example : " + (a * b));

		BiConsumer<Integer, Integer> subtractionBiConsumer = (a, b) -> System.out
				.println("SubtractionBiConsumer Example : " + (a - b));

		multiplicationBiConsumer.accept(34, 10);
		subtractionBiConsumer.accept(45, 10);

		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- --- ---");

		additionBiConsumer.andThen(multiplicationBiConsumer).andThen(subtractionBiConsumer).accept(50, 40);
	}

}
