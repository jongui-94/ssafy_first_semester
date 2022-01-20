package com.ssafy.hw04.step3;

public class Tv extends Product{
	private int inch;
	private String dptype;
	
	public Tv(String name, String num, int price, int stock, int inch, String dptype) {
		super(name, num, price, stock);
		this.inch = inch;
		this.dptype = dptype;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDptype() {
		return dptype;
	}

	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	@Override
	public String toString() {
		return "상품명: " + super.getName()+ " 상품번호: " + super.getNum() + 
				" 상품가격: " + super.getPrice() + " 상품재고: " + super.getStock() +
				" 인치: " + inch + " 타입: " + dptype;
	}

	
	
	
	
	

	

	
	
	
	

}
