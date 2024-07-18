package com.java.Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.start.java.person.Person;
import com.start.java.person.PersonRepository;

public class Stream_Map {

	final static Logger logger = Logger.getLogger(Stream_Map.class.getName());

	public static void main(String[] args) {

		List<String> fruitList = Arrays.asList("Apple", "Orange", "PineApple", "Banana");

		Map<String, Integer> collect = fruitList.stream().collect(Collectors.toConcurrentMap(t -> t, o -> o.length()));
		System.out.println(collect);

		logger.info("-------------------------------------------");

		List<Integer> lengthMap = fruitList.stream().map(String::length).toList();
		System.out.println(lengthMap);

		logger.info("-------------------------------------------");

		List<String> list = PersonRepository.getAllPersons().stream().map(Person::getName).map(String::toUpperCase)
				.toList();
		System.out.println(list);

		logger.info("-------------------------------------------");

		Set<String> set = PersonRepository.getAllPersons().stream().map(Person::getName).map(String::toUpperCase)
				.collect(Collectors.toSet());
		System.out.println(set);

	}

}
