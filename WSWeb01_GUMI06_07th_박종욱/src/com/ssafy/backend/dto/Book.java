package com.ssafy.backend.dto;

import java.io.Serializable;

public class Book implements Serializable {
	
	protected String isbn;
	protected String title;
	protected String author;
	protected int price;
	protected String desc;

	public Book() {}			

	public Book(String isbn,String title,String author,int price,String desc) {
		this.isbn=isbn;
		this.title = title;
		this.author = author;
		this.price=price;
		this.desc = desc;
		
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=");
		builder.append(isbn+"\t|");
		builder.append(", title=");
		builder.append(title+"\t|");
		builder.append(", author=");
		builder.append(author+"\t|");
		builder.append(", price=");
		builder.append(price+"\t|");
		builder.append(", desc=");
		builder.append(desc+"\t|");
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
	
}

