package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MaintTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
//		Student s1 = (Student) ctx.getBean("student1");
//		System.out.println(s1);
		
		Teacher t1 = (Teacher) ctx.getBean("teacher1");
		System.out.println(t1);
		System.out.println(t1.getStudents().size());
		System.out.println(t1.getTotal());

	}

}
