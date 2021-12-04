package com.study.spring.case6.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

//新增 Create
public class CreateEmp {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		@Test
		public void test() {
			case3();
		}
		//	單筆新增
		public void case1() {
			String sql = "Insert into emp(ename,age) VALUES(?,?)";
			jdbcTemplate.update(sql, "Jo",21);
			System.out.println("Insert ok 1");
		}
		
		//	多筆新增I
		public void case2() {
			String sql = "Insert into Emp(ename,age) VALUES(?,?)";
			List<Object[]> list = new ArrayList<Object[]>();
			list.add(new Object[] {"Jean",22});
			list.add(new Object[] {"helen",23});
			list.add(new Object[] {"jack",24});
			int [] rows = jdbcTemplate.batchUpdate(sql,list);
			System.out.println(Arrays.toString(rows));
		}
		
		//	多筆新增II
		public void case3() {
			String sql = "Insert into emp(ename,age) VALUES(?,?)";
			List<Emp> emps = Arrays.asList(
					new Emp("Yun2",30),
					new Emp("Cindle", 28)
					);
			BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					// i = emps 的index
					ps.setString(1, emps.get(i).getEname());
					ps.setInt(2, emps.get(i).getAge());
					
				}
				
				@Override
				public int getBatchSize() {
					return emps.size();
				}
			};
			int [] rows = jdbcTemplate.batchUpdate(sql,setter);
			System.out.println(Arrays.toString(rows));
					
		}
}
