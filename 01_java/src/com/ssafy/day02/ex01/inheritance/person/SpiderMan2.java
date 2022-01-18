package com.ssafy.day02.ex01.inheritance.person;

//has a 관계 설명
public class SpiderMan2 extends Person{
	Spider spider = new Spider();
	boolean isSpider;
	
	void fireWeb()
	{
		if(isSpider)
		{
			spider.fireWeb();
		}
		else
		{
			System.out.println("Person은 거미줄 발사 불가");
		}
	}
	@Override
	void jump()
	{
		if(isSpider)
		{
			spider.jump();
		}
		else
		{
			super.jump();
		}
	}
	
	
	
	

}
