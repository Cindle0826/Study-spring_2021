package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.Student;

public class MainTest {

	public static void main(String[] args) {
		/**
		 * scope 如果設 singleton 會先掃描自動建立 prototype要指定有getBean才會執行
		 * destory 要使用要設置 singleton
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		Student student = (Student) ctx.getBean("student1");
		Student student2 = (Student) ctx.getBean("student1");
		System.out.println(student);
		System.out.println(student2);
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
