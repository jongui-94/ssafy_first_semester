package com.ssafy.hw.step3;
import java.util.List;
import java.util.ArrayList;

public class ProductMgr {
	
	private Product[] products = new Product[10];
	int index = 0;
	
	//상품 정보 저장
	public void add(Product pd) {
		products[index] = pd;
		index++;
	}
	
	//상품전체검색
	public Product[] show() {
		Product[] result = new Product[index];
		for(int i = 0; i < index; i++)
		{
			result[i] = products[i];
		}
		return result;
	}
	
	//상품번호로 상품 검색
	public Product search_num(int num){
		
		for(int i = 0; i<index;i++)
		{
			if(products[i].getNum() == num)
			{
				return products[i];
			}
		}
		return null;
	}
	
	//상품명으로 상품 검색
	public Product[] search_name(String name) {
		List<Product> list = new ArrayList<>();
		
		for(int i = 0; i<index;i++)
		{
			if(products[i].getName().contains(name))
			{
				list.add(products[i]);
			}
		}
		return list.toArray(new Product[list.size()]);
		
	}
	//TV정보
	public Product[] just_Tv() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		for(int i =0; i<index; i++) 
		{
			if(products[i] instanceof Tv)
			{
				list.add(products[i]);
			}
		}
		return list.toArray(new Product[list.size()]);
	}
	//Refrigerator정보
	public Product[] just_Re() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		for(int i =0; i<index; i++) 
		{
			if(products[i] instanceof Refrigerator)
			{
				list.add(products[i]);
			}
		}
		return list.toArray(new Product[list.size()]);
	}
	
	public void del(int num) {
		if (index == 0)
			System.out.println("상품이 없습니다.");
		else
		{
			for(int i = 0; i<index;i++)
			{
				if(products[i].getNum() == num)
				{
					for(int j = i; j<index-1;j++)
					{
						products[j]= products[j+1];
					}
				}
			}
			products[index] = new Product();
			index--;
		}	
	}
	
	public int total_Price() {
		int total=0;
		int sum;
		for(int i =0;i<index;i++)
		{
			sum = products[i].getPrice() * products[i].getStock();
			total += sum;
		}
		return total;
	}
	
	

}
