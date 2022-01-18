package com.ssafy.hw.step3;

public class Refrigerator extends Product{
	
	private int capacity;
	private int height;
	
	public Refrigerator(String name, int num, int price, int stock, int capacity, int height) {
		super(name, num, price, stock);
		this.capacity = capacity;
		this.height = height;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Refrigerator [capacity=" + capacity + ", height=" + height + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
