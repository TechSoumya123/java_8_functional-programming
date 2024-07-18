package com.java.Local_variable;

import java.util.function.Consumer;

public class Example_Local_Variable {

	static int k = 0;

	public static void main(String[] args) {

		int i = 9;
		Consumer<Integer> consumer = j -> {
//			i++;
			k=10;
			System.out.println(i + j + k);
		};
		consumer.accept(10);

	}

}
