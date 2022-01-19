package com.ssafy.ws07.step3;

public class QuantityException extends Exception{
	public QuantityException() {
		super("재고가 부족합니다.");
	}

}
