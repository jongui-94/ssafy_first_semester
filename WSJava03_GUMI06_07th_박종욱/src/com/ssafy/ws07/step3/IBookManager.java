package com.ssafy.ws07.step3;

public interface IBookManager{
	void add(Book book);
	void remove(String isbn);
	int getTotalPrice();
	double getPriceAvg();

}
