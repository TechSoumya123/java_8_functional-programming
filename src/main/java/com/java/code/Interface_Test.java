package com.java.code;

@FunctionalInterface
interface ITest_Interface {
	void add();

	default String methodExample() {
		return "Default Method..";
	}

	static boolean isFalse() {
		return false;
	}
}

public class Interface_Test {

	public static void main(String[] args) {

		ITest_Interface test_Interface = () -> System.out.println("ok....");
		test_Interface.add();
	}

}
