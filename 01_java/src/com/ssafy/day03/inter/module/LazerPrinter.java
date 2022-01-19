package com.ssafy.day03.inter.module;

public class LazerPrinter implements Printer {

	@Override
	public void print(String fileName) {
		System.out.println(fileName + "파일을 Lazer Printer로 프린트한다.");
		
	}
	

}
