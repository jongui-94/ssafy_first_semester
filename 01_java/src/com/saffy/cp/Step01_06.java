package com.saffy.cp;
import java.util.Scanner;

public class Step01_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int min = 1000;
		
		for(int i= 0;i<10;i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i] <min)
				min = arr[i];
		}
		System.out.println(min);

	}

}
