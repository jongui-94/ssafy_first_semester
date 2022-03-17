package com.tophoon.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestDrive {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/com/tophoon/config/applicationContext.xml");
		MyBean bean = (MyBean) context.getBean("mybean");
		bean.sayHello();
	}
}
