package com.ssafy.day02.ex03.polymorphism;

public class ToStringTest {
	
	public static void main(String[] args) {
		Fruit apple = new Fruit("사과", 10000, "사과맛");
		Fruit grape = new Fruit("포도", 20000, "포도맛");
		
		Object[] fArr = new Fruit[2];
		fArr[0] = apple;
		fArr[1] = grape;
		
		for(Object o: fArr) {
			if(o instanceof Fruit) {
				Fruit f = (Fruit) o;
				System.out.println(f);
			}
			
		}
	}

}

class Fruit{
	String name;
	int price;
	String taste;
	
	
	public Fruit(String name, int price, String taste) {
		super();
		this.name = name;
		this.price = price;
		this.taste = taste;
	}


	// alt + shift + s
	// JDK 1.5이상일 경우는 아래처럼 작성
	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + ", taste=" + taste + "]";
	}
	
	//JDK 1.4이하면 
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Fruit [name=");
//		builder.append(name);
//		builder.append(", price=");
//		builder.append(price);
//		builder.append(", taste=");
//		builder.append(taste);
//		builder.append("]");
//		return builder.toString();
//	}
	
	
	
}
