package com.ssafy.ws.step3;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BookManager {
	final int MAX_SIZE = 100;
	Book[] books = new Book[MAX_SIZE];
	private int index = 0;
	
	public void add(Book book) {
		books[index] = book;
		index++;
	}
	
	public void remove(String isbn) {
		int value = 0;
		for(int i = 0; i< index; i++)
		{
			if(books[i].getIsbn().equals(isbn))
			{
				value = i;
				break;
			}
		}
		for(int i = value; i<index; i++)
		{
			books[i] = books[i+1];
		}
		books[index] = null;
		index--;
	}
	
	public Book[] getList() {
		return Arrays.copyOf(books, index);

	}
	
	public Book searchByIsbn(String isbn) {
		Book result = new Book();

		for (int i = 0; i<index; i++) {
			if(isbn.equals(books[i].getIsbn())) {
				result = books[i];
				break;
			}
		}
		return result;
	}
	
	public Book[] searchByTitle(String title) {
		List<Book> list = new ArrayList<>();
		
		for(int i = 0; i<index; i++) {
			if(books[i].getTitle().contains(title))
				list.add(books[i]);
		}
		
		Book[] result = new Book[list.size()];
		for(int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return result;
	}
	
	public Book[] getBooks() {
		List<Book> list = new ArrayList<Book>();
		
		for(int i = 0; i < index; i++) {
			if(!(books[i] instanceof Magazine))
				list.add(books[i]);
		}
		
		return list.toArray(new Book[list.size()]);
	}
	
	public Book[] getMagazines() {
		List<Book> list = new ArrayList<>();
		
		for(int i = 0; i < index; i++) {
			if(books[i] instanceof Magazine)
				list.add(books[i]);
		}
		
		Book[] result = new Book[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return result;
		
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(int i = 0; i < index; i++) {
			sum += books[i].getPrice();
		}
		
		return sum;
	}
	
	public double getPriceAvg() {
		double avg = 0.0;
		
		for(int i = 0; i < index; i++) {
			avg += books[i].getPrice();
		}
		
		avg /= index;
		
		return avg;
	}







}
