package com.study.spring;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.study.spring.case04.Person;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class JsonDBTest {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("src/main/java/com/study/spring/case04/person.json");
		List<String> list=Files.readAllLines(path);
		// List 合併 String 
		String json = list.stream().collect(Collectors.joining());
		System.out.println(json);
		// List<Person> 
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> people = gson.fromJson(json, type);
		System.out.println(people);
		//新增一比 Person 到 people 集合中
		Person person = new Person();
		person.setName(new Faker().name().firstName());
		person.setAge(10);
		person.setBirth(new Faker().date().birthday());
		people.add(person);
		System.out.println(people);
		// 將 people 集合回存到 person.json
		json = gson.toJson(people);
		Files.write(path, json.getBytes("utf-8"));
		
	}
}
