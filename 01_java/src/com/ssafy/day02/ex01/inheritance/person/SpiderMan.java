package com.ssafy.day02.ex01.inheritance.person;

public class SpiderMan extends Person{
	
	boolean isSpider; //일반 시민: false, 거미인간: true
	
	void fireWeb()
	{
		System.out.println("거미줄 발사");
	}

}
