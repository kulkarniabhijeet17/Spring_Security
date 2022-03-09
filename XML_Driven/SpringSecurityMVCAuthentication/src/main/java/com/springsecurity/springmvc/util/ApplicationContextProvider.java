package com.springsecurity.springmvc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextProvider {
	public static Object getBean(String bean) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application_beans.xml");
		
		return context.getBean(bean);
	}
}