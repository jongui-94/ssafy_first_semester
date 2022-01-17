package com.java.first;
import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		int wei, hei, level;
		Scanner sc = new Scanner(System.in);
		
		hei = sc.nextInt();
		wei = sc.nextInt();
		level = wei + 100 - hei;
		System.out.println("비만수치는 "+level +"입니다.");
		if(level>0)
			System.out.println("당신은 비만이군요");
	}

}
