package com.ssafy.day02.q01;

import java.lang.reflect.*;

//import com.sun.org.apache.bcel.internal.classfile.Field;

class Person{
	private String name;
	private int age;
	
	public Person() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		// reflection을 이용해 클래스 정보를 가져오기
		// 이유: new 키워드 사용하지 않고 객체를 생성하기 위해서
		Class myClass1 = Person.class;
		Class myClass2 = new Person().getClass();
		Class myClass3 = Class.forName("com.ssafy.day02.q01.Person");
		Object object3 = myClass3.newInstance();
		
		Field[] fieldArray = myClass3.getDeclaredFields();
		for(Field f:fieldArray) {
			System.out.println(f.getName());
		}
		
		Method[] methodArray = myClass3.getDeclaredMethods();
		for (Method m:methodArray) {
			if(m.getName().startsWith("setName")) {
				m.invoke(new Person(),  "김싸피");
			}
		}
		
	}
}
