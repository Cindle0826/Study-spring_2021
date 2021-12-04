package com.study.spring.case6.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SelectAll {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		String sql = "SELECT * FROM Book";
		System.out.println(jdbcTemplate.queryForList(sql));

		sql = "SELECT * FROM stock";
		System.out.println(jdbcTemplate.queryForList(sql));

		sql = "SELECT * FROM wallet";
		System.out.println(jdbcTemplate.queryForList(sql));

	}
}
