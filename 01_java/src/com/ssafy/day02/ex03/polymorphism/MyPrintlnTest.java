package com.ssafy.day02.ex03.polymorphism;

import com.ssafy.day02.ex01.inheritance.person.Person;
import com.ssafy.day02.ex01.inheritance.person.SpiderMan;

public class MyPrintlnTest {
	
	void println(Object obj)
	{
		System.out.println(obj.toString());
	}
	
	public static void main(String[] args) {
		
		Person p = new Person();
		SpiderMan sman = new SpiderMan();
		
	}

}
