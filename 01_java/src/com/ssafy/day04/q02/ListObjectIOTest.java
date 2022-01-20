package com.ssafy.day04.q02;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ListObjectIOTest {
	
	public static void main(String[] args) {
		// 1. 책 객체를 3개 생성
		Book b1 = new Book("1", "java세계", "종긔", "삼성", 500, "java", 3);
		Book b2 = new Book("2", "python세계", "종긔", "삼성", 300, "java", 5);
		Book b3 = new Book("3", "kotlin세계", "종긔", "삼성", 700, "java", 15);
		// 2. 1번에서 만든 객체를 ArrayList에 담기
		ArrayList<Book> list = new ArrayList<Book>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		// 3. 2번에서 만든 ArrayList 객체를 파일에 저장 (ObjectIOTestDrive 예제 참고)
		// book_data.dat
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("book_data.dat");
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
		
		// 4. 저장된 파일에서 ArrayList 객체 정보를 읽어오기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("book_data.dat");
			ois = new ObjectInputStream(fis);

			Object p = null;
			while ((p = ois.readObject()) != null) {
				System.out.println(p);
			}
		}
		catch (FileNotFoundException e) {
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
		// 5. sysout 메서드를 이용해서 리스트 출력
		
		// 6. 파일 입출력 관련 변수들 close() 호출하여 정리
	}

}
