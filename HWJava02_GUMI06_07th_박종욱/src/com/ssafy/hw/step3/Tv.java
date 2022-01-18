package com.ssafy.hw.step3;

public class Tv extends Product{
	private int inch;
	private String dptype;
	
	public Tv(String name, int num, int price, int stock, int inch, String dptype) {
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
		return "Tv [inch=" + inch + ", dptype=" + dptype + "]";
	}
	
	
	
	

	

	
	
	
	

}
