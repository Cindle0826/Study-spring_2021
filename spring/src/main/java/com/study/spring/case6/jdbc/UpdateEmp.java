package com.study.spring.case6.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateEmp {
	/**
	 * System.out.println("Upate rowcount: " + rowcount); rowcount 顯示 0 就是沒有找到
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		int id = 10;
		String sql = "Update emp set ename = ?, age = ? where eid = ?";
		int rowcount =  jdbcTemplate.update(sql,"John2",27,id); // "John2" , 27 , id=1 就是sql 「?」 號的順序
		System.out.println("Upate rowcount: " + rowcount);
	}
}
