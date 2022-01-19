package com.ssafy.day03.abs;

abstract public class DieselSUV extends Vehicle{
	//private int curX, curY;
	
//	public void reportPosition() {
//		System.out.printf("현재 위치: (%d, %d)%n", super.getCurX(), super.getCurY());
//	}
	
	@Override
	public void addFuel() {
		System.out.printf("주유소에서 급유");
	}
	
	abstract public void test();
}


