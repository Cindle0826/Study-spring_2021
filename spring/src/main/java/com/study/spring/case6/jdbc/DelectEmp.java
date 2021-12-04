package com.study.spring.case6.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DelectEmp {
	/**
	 * System.out.println("Upate rowcount: " + rowcount); rowcount 顯示 0 就是沒有找到
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		int id = 12;
		String sql = "Delete from Emp where eid = ?";
		int rowcount =  jdbcTemplate.update(sql,id);
		System.out.println("Delete rowcount" + rowcount);
		
	}
}
