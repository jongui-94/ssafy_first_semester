package com.ssafy.ws04.step3;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BookManagerlmpl implements IBookManager {

	private static BookManagerlmpl instance;

	private BookManagerlmpl() {
		loadData();
	}

	public static BookManagerlmpl getInstance() {
		if (instance == null) {
			instance = new BookManagerlmpl();
		}
		return instance;
	}

	ArrayList<Book> list = new ArrayList<Book>();

	// 책 추가
	public void add(Book book) {
		list.add(book);

	}

	// 책 삭제
	public void remove(String isbn) {
		for (Book book : list) {
			if (book.getIsbn().equals(isbn)) {
				list.remove(book);
			}
		}
	}

	// 전체 목록리스트
	public void getList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// 번호로 책찾기
	public void searchByIsbn(String isbn) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIsbn().equals(isbn)) {
				System.out.println(list.get(i));
			}
		}
	}

	// 제목으로 책찾기
	public void searchByTitle(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().contains(title)) {
				System.out.println(list.get(i));
			}
		}

	}

	// 책 목록 좌르륵
	public void getBooks() {

		for (int i = 0; i < list.size(); i++) {
			if (!(list.get(i) instanceof Magazine)) {
				System.out.println(list.get(i));
			}
		}
	}

	// 잡지 목록 좌르륵
	public void getMagazines() {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Magazine)
				System.out.println(list.get(i));
		}

	}

	// 전체 가격
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += (list.get(i).getPrice()) * (list.get(i).getQuantity());
		}

		return sum;
	}

	// 평균 가격
	public double getPriceAvg() {
		double avg = 0.0;

		for (int i = 0; i < list.size(); i++) {
			avg += list.get(i).getPrice();
		}

		avg /= list.size();

		return avg;
	}

	// 책구매
	public void buy(String isbn, int quantity) {
		boolean check = false;
		for (Book book : list) {
			if (book.getIsbn().equals(isbn)) {
				book.setQuantity(book.getQuantity() + quantity);
				check = true;
				break;
			}
		}
		if (check == false) {
			try {
				throw new ISBNNotFoundException();
			} catch (ISBNNotFoundException e) {
				System.out.println(e);
			}
		}

	}

	// 책판매
	public void sell(String isbn, int quantity) {
		boolean check = false;
		for (Book book : list) {
			if (book.getIsbn().equals(isbn)) {
				check = true;
				if (book.getQuantity() >= quantity) {
					book.setQuantity(book.getQuantity() - quantity);
					break;
				} else {
					try {
						throw new QuantityException();
					} catch (QuantityException e) {
						System.out.println(e);
						
					}
				}
			}
		}
		if (check == false) {
			try {
				System.out.println("나오나");
				throw new ISBNNotFoundException();
			} catch (ISBNNotFoundException e) {
				System.out.println(e);
			}
		}
	}
	//book.dat 파일에 도서리스트 저장하는 메서드
	public void saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("book.dat");
			oos = new ObjectOutputStream(fos);
			
			for(Book book : list) {
				oos.writeObject(book);
			}
			oos.writeObject(null);

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("객체 정보를 파일에 저장 완료!");
	}
	//book.dat 파일에서 도서리스트를 읽어오는 메서드
	synchronized private void loadData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("book.dat");
			ois = new ObjectInputStream(fis);

			Object p = null;
			while ((p = ois.readObject()) != null) {
				System.out.println(p);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("등록된 도서가 없습니다.");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
