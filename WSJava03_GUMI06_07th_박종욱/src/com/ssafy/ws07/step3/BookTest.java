package com.ssafy.ws07.step3;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManagerlmpl bm =BookManagerlmpl.getInstance();
		
		Book b1 = new Book("1", "java세계", "종긔", "삼성", 500, "java", 3);
		Book b2 = new Book("2", "python세계", "종긔", "삼성", 300, "python", 5);
		
		Magazine m1 = new Magazine("3", "바다세계", "whdrml", "삼성", 800, "nature", 7, 2022, 01);
		Magazine m2 = new Magazine("4", "우주세계", "whdrml", "삼성", 200, "nature", 2, 2021, 12);
		
		bm.add(b1);
		bm.add(b2);
		bm.add(m1);
		bm.add(m2);
		
		//전체목록
		System.out.println("********************************도서 전체 목록********************************");
		bm.getList();

		
		//도서번호 검색
		System.out.println("********************************도서 번호 검색: " + "1"+ "********************************");
		bm.searchByIsbn("1");


		//도서 제목 포함검색
		System.out.println("********************************도서 제목 포함검색: " + "python" + "********************************");
		bm.searchByTitle("python");
		
		//일반도서
		System.out.println("********************************일반 도서 목록********************************");
		bm.getBooks();

		
		//잡지
		System.out.println("********************************잡지 목록********************************");
		bm.getMagazines();
		


		//도서 전체 가격
		System.out.print("도서 가격 총합: " );
		System.out.println(bm.getTotalPrice());
		
		//도서 평균 가격
		System.out.print("도서 가격 평균: " );
		System.out.println(bm.getPriceAvg());
		
		//책구매
		System.out.println("********************************도서구매:1,3권********************************");
		bm.buy("1", 3);
		
		//책판매
		bm.sell("2", 4);
		System.out.println("********************************도서판매:2,4권********************************");
		
		System.out.println("********************************도서 전체 목록********************************");
		bm.getList();
		
		//없는번호 구매
		bm.buy("5", 4);
		//없는재고 판매
		bm.sell("4",3);

	}

}
