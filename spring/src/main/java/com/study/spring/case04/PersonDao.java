package com.study.spring.case04;

import java.util.List;

public interface PersonDao {

	boolean add(Person person);

	List<Person> queryAll();
}
