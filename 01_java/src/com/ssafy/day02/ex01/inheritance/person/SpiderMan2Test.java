package com.ssafy.day02.ex01.inheritance.person;

public class SpiderMan2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiderMan2 spiderMan = new SpiderMan2();
		System.out.println("거미 모드로 변신!!");
		spiderMan.isSpider = true;
		spiderMan.jump();
		
		System.out.println("사람으로 변신!!");
		spiderMan.isSpider = false;
		spiderMan.jump();
		
		System.out.println(spiderMan.toString());

	}

}
