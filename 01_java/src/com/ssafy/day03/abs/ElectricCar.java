package com.ssafy.day03.abs;

abstract public class ElectricCar extends Vehicle{
	//private int curX, curY;
	
//	public void reportPosition() {
//		System.out.printf("현재 위치: (%d, %d)%n", super.getCurX(), super.getCurY());
//	}
	
	@Override
	public void addFuel() {
		System.out.printf("급속 충전");
	}
}


