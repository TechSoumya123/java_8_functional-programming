package com.java.Bi_Function;

import java.util.function.BiFunction;

public class Example_BiFunction {

	static BiFunction<String, String, String> concatBiFunction = (t1, t2) -> (t1 + " " + t2);

	public static void main(String[] args) {
		System.out.println(concatBiFunction.apply("Java", "features"));
	}

}
