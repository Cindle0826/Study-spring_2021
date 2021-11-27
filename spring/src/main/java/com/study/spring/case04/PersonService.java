package com.study.spring.case04;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface PersonService {
	boolean append(Person person);
	List<Person> findAll();
	
}
