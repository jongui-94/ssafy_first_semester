package com.saffy.cp;

import java.util.Scanner;

public class Step01_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[10];
		Scanner sc = new Scanner(System.in);
		
		for(int i =0; i<10; i++)
		{
			arr[i] = sc.next().charAt(0);
		}
		
		for(char j:arr)
		{
			System.out.print(j);
		}

	}

}
