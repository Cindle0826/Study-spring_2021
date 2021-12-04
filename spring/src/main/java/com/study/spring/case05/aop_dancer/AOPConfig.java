package com.study.spring.case05.aop_dancer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//	使用 Java 配置代替 aop-config.xml proxy 代理
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AOPConfig {
	@Bean(name = "dancer")
	public Performance dancer() {
		return new Dancer();
	}

	@Bean(name = "audience")
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	Introducter getIntroducter() {
		return new Introducter();
	}
}
