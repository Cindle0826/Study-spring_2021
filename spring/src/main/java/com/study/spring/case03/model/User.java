package com.study.spring.case03.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:user.properties")
public class User {
	@Value("${user.name}")
	private String name;
	@Value("${user.age}")
	private Integer age;

	@Value("${user.nikename}")
	private String[] nikename; // 暱稱

	@Value("#{${user.subjects}}")
	private Set<String> subjects; // 科目

	@Value("#{'${user.scores}'.split(',')}")
	private List<Integer> scores; // 成績

	@Value("#{${user.hobbies}}")
	private Map<String, String> hobbies;

	public String[] getNikename() {
		return nikename;
	}

	public void setNikename(String[] nikename) {
		this.nikename = nikename;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", nikename=" + Arrays.toString(nikename) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}

}
