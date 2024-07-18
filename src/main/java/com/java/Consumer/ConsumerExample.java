package com.java.Consumer;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class ConsumerExample {

	final static Logger logger = Logger.getLogger(ConsumerExample.class.getName());

	public static void main(String[] args) {

		Consumer<String> toUpperCase = data -> System.out.println(data.toUpperCase());
		toUpperCase.accept("Consumer Example...");

		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

		Consumer<String> toLowerCase = data -> System.out.println(data.toLowerCase());
		toLowerCase.accept("Consumer Example...");

		logger.info(() -> "--- --- --- --- --- --- --- --- --- --- --- --- ");

		toUpperCase.andThen(toLowerCase).accept("Consumer...Example...");
	}

}
