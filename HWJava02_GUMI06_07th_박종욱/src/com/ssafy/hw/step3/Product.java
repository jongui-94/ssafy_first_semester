package com.ssafy.hw.step3;

public class Product {
	
	
	private String name;
	private	int num;
	private int price;
	private int stock;
	
	public Product() {}
	public Product(String name, int num, int price, int stock) {
		this.name = name;
		this.num = num;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", num=" + num + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
	

	

	
	
	
	
	
	
	
}


