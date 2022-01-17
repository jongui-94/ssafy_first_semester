package com.saffy.cp;
import java.util.Scanner;

public class Step01_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int sto = 0;
		
		for(int i=0;i<10;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		for(int k = 0;k<arr.length;k++)
		{
			for(int t = 0;t<arr.length-1;t++)
			{
				if(arr[t]<arr[t+1])
				{
					sto = arr[t];
					arr[t] = arr[t+1];
					arr[t+1] = sto;
				}
			}
		}
		for(int a:arr)
		{
			System.out.print(a+" ");
		}

	}

}
