package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManager bm = new BookManager();
		
		Book b1 = new Book("1", "java세계", "종긔", "삼성", 500, "java");
		Book b2 = new Book("2", "python세계", "종긔", "삼성", 300, "python");
		
		Magazine m1 = new Magazine("3", "바다세계", "whdrml", "삼성", 800, "nature", 2022, 01);
		Magazine m2 = new Magazine("4", "우주세계", "whdrml", "삼성", 200, "nature", 2021, 12);
		
		bm.add(b1);
		bm.add(b2);
		bm.add(m1);
		bm.add(m2);
		
		//전체목록
		System.out.println("********************************도서 전체 목록********************************");
		for(Book book : bm.getList()) {
			System.out.println(book.toString());
		}

		
		//도서번호 검색
		System.out.println("********************************도서 번호 검색: " + "1"+ "********************************");
		System.out.println(bm.searchByIsbn("1").toString());


		//도서 제목 포함검색
		System.out.println("********************************도서 제목 포함검색: " + "python" + "********************************");
		System.out.println(Arrays.toString(bm.searchByTitle("python")));
		
		//일반도서
		System.out.println("********************************일반 도서 목록********************************");
		for(Book book : bm.getBooks()) {
			System.out.println(book.toString());
		}

		
		//잡지
		System.out.println("********************************잡지 목록********************************");
		for(Book book : bm.getMagazines()) {
			System.out.println(book.toString());
		}	


		//도서 전체 가격
		System.out.print("도서 가격 총합: " );
		System.out.println(bm.getTotalPrice());
		
		//도서 평균 가격
		System.out.print("도서 가격 평균: " );
		System.out.println(bm.getPriceAvg());



	}

}
