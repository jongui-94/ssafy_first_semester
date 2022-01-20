package com.ssafy.hw04.step3;

public class Refrigerator extends Product{
	
	private int capacity;
	private int height;
	
	public Refrigerator(String name, String num, int price, int stock, int capacity, int height) {
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
		return "상품명: " + super.getName()+ " 상품번호: " + super.getNum() + 
				" 상품가격: " + super.getPrice() + " 상품재고: " + super.getStock() +
				" 용량: " + capacity + " 높이: " + height;
	}
	
	
	
	
	
	
	
	
	
	

}
