package com.study.spring.case04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;

	public boolean addPerson(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		person.setAge(calcTime(birth));
		return personService.append(person);
	}

	public List<Person> queryPerson() {
		return personService.findAll();
	}

	/**
	 * 先利用 SimpleDateFormat 制定標準格式 在讓Date轉換成String 在轉回Date 現在減生日 
	 * @param birth 生日
	 * @param end   現在時間
	 * @return
	 */
	public Integer calcTime(Date birth) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm::ss");
		
		try {
			String sbirth = sdf.format(birth);
			String sEnd = sdf.format(new Date());
			Date date_birth = sdf.parse(sbirth);
			Date date_end = sdf.parse(sEnd);
			Long date_now = date_end.getTime() - date_birth.getTime();
			Integer years = (int) (date_now / (1000l * 60 * 60 * 24 * 365));

			return years;
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}
}
