package com.ssafy.hw03.step3;

import java.util.Arrays;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgrlmpl pm = ProductMgrlmpl.getInstance();
		
		Tv tv1 = new Tv("삼성티비", "1111", 30000, 2, 50, "superled");
		Tv tv2 = new Tv("엘지티비", "2222", 10000, 6, 40, "led");
		
		Refrigerator re1 = new Refrigerator("삼성냉장고", "3333", 50000, 1, 1000, 2);
		Refrigerator re2 = new Refrigerator("엘지냉장고", "4444", 40000, 3, 800, 1);
		
		pm.add(tv1);
		pm.add(tv2);
		pm.add(re1);
		pm.add(re2);
		
		System.out.println("상품정보 전체");
		pm.getList();
		System.out.println();
		
		System.out.println("번호로 검색");
		pm.search_num("1111");
		System.out.println();
		
		System.out.println("상품명으로 검색");
		pm.search_name("엘지냉장고");
		System.out.println();
		
		System.out.println("티비만 나와라");
		pm.just_Tv();
		System.out.println();
		
		System.out.println("냉장고만 나와라");
		pm.just_Re();
		System.out.println();
		
		System.out.println("전체 금액");
		pm.total_Price();	
		System.out.println();
		
		System.out.println("번호로 삭제: 2222");
		pm.del("2222");
		System.out.println();
		
		System.out.println("상품정보 전체");
		pm.getList();
		System.out.println();
		
		System.out.println("인치로 검색");
		pm.search_Inch(50);
		System.out.println();
		
		System.out.println("용량으로 검색");
		pm.search_Capacity(900);
		System.out.println();
		
		System.out.println("상품번호와 가격을 입력받아 가격 변경");
		pm.change_Price("3333", 400000);
		System.out.println();
		
		System.out.println("상품정보 전체");
		pm.getList();
		System.out.println();
	}

}
