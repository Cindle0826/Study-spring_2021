package com.study.spring.case02;

import java.util.Set;
import java.util.function.ToIntFunction;

public class Teacher {
	private Integer id;
	private String name;
	private Set<Student> students;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	public int getTotal() {
		int total = 0;
		if(students != null) {
			ToIntFunction<Student> fun1 = s -> s.getClazzs().stream().mapToInt(c -> c.getCredit()).sum();
			total = students.stream().mapToInt(fun1).sum();
		}
		return total;
	}

}
