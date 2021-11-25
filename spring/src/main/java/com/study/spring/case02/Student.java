package com.study.spring.case02;

public class Student {
	private Integer id;
	private String name;

	public Student() {
		System.out.println("constructor");
		System.out.println(super.toString());
	}

	public void intit() {
		System.out.println("Student init");
	}

	public void destory() {
		System.out.println("Student destroy");
	}

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
