package com.ssafy.day03.abs;

abstract class Vehicle {
	private int curX, curY;

	public void reportPosition() {
		System.out.printf("νμ¬ μμΉ: (%d, %d)%n", curX, curY);
	}

	public abstract void addFuel();
	public abstract void test();

	public int getCurX() {
		return curX;
	}

	public void setCurX(int curX) {
		this.curX = curX;
	}

	public int getCurY() {
		return curY;
	}

	public void setCurY(int curY) {
		this.curY = curY;
	}
	
	
}


