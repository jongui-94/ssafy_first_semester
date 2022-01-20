package com.ssafy.ws04.step3;

public class ISBNNotFoundException extends Exception{
	public ISBNNotFoundException() {
		super("해당 도서의 ISBN이 존재하지 않습니다.");
	}

}
