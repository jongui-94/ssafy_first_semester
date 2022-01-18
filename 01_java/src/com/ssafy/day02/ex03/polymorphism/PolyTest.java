package com.ssafy.day02.ex03.polymorphism;

import com.ssafy.day02.ex01.inheritance.person.Person;
import com.ssafy.day02.ex01.inheritance.person.SpiderMan;

public class PolyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiderMan onlyOne = new SpiderMan();
		
		Person person = onlyOne;
		
		Object object = onlyOne;
		
		//Venom venom = onlyOne;

	}

}

class Venom extends SpiderMan{
	
}
