package com.java.first;
import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.println("곱= "+ a*b);
		System.out.println("몫= "+ a/b);
	}

}
