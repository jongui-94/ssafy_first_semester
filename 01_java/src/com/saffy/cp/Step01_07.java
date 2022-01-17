package com.saffy.cp;
import java.util.Scanner;

public class Step01_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int min = 0;
		int max = 10000;
		
		for(int i= 0;i<10;i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i]<100)
			{
				if(arr[i]>min)
					min = arr[i];
			}
			else if(arr[i]>100)
			{
				if(arr[i]<max)
					max = arr[i];
			}
		}
		if(min ==0)
			min =100;
		if(max ==10000)
			max = 100;
		System.out.println(min+" "+ max);

	}

}
