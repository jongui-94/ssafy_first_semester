package com.saffy.cp;
import java.util.Scanner;

public class Step01_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int sum2=0;
		double avg;
		
		for(int i=0;i<10;i++)
		{
			arr[i] = sc.nextInt();
			if(i%2==0)
				sum2+=arr[i];
			else
				sum +=arr[i];
		}
		avg = (double)sum2/5;
		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		
 
	}

}
