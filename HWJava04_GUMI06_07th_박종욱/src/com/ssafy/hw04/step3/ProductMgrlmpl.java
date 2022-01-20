package com.ssafy.hw04.step3;

import java.util.List;

import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrlmpl implements IProductMgr {

	private static ProductMgrlmpl instance;

	private ProductMgrlmpl() {
		loadData();
	}

	public static ProductMgrlmpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrlmpl();
		}
		return instance;
	}

	ArrayList<Product> list = new ArrayList<Product>();

	// 상품 정보 저장
	public void add(Product pd) {
		list.add(pd);
	}

	// 상품전체검색
	public void getList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// 상품번호로 상품 검색
	public void search_num(String num) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum().equals(num)) {
				System.out.println(list.get(i));
			}
		}
	}

	// 상품명으로 상품 검색
	public void search_name(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(name)) {
				System.out.println(list.get(i));
			}
		}

	}

	// TV정보
	public void just_Tv() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Tv) {
				System.out.println(list.get(i));
			}
		}
	}

	// Refrigerator정보
	public void just_Re() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Refrigerator)
				System.out.println(list.get(i));
		}
	}

	// 상품 번호로 삭제

	public void del(String num) {
		Iterator<Product> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().getNum().equals(num)) {
				it.remove();
			}
		}
	}

	// 전체 가격
	public void total_Price() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += (list.get(i).getPrice()) * (list.get(i).getStock());
		}
		System.out.println(sum);

	}

	// inch로 티비 검색
	public void search_Inch(int inch) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Tv) {
				if (((Tv) list.get(i)).getInch() >= inch) {
					System.out.println(list.get(i));
				}
			}
		}
	}

	// 용량으로 냉장고 검색
	public void search_Capacity(int capacity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Refrigerator) {
				if (((Refrigerator) list.get(i)).getCapacity() >= capacity) {
					System.out.println(list.get(i));
				}
			}
		}
	}

	// 상품번호와 가격을 입력받아 가격 변경
	public void change_Price(String num, int price) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum().equals(num)) {
				list.get(i).setPrice(price);
			}
		}

	}
	//정보 저장
	public void saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("product.dat");
			oos = new ObjectOutputStream(fos);
			
			for(Product product : list) {
				oos.writeObject(product);
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
	//정보 불러오기
	synchronized private void loadData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("product.dat");
			ois = new ObjectInputStream(fis);

			Object p = null;
			while ((p = ois.readObject()) != null) {
				System.out.println(p);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("등록된 상품이 없습니다.");
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
