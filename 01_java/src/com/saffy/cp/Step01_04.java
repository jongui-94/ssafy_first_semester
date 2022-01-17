package com.saffy.cp;
import java.util.Scanner;

public class Step01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		int value = 0;
		
		for(int i=0;i<100;i++)
		{
			arr[i]= sc.nextInt();
			if(arr[i] == 0)
			{
				value = i;
				break;
			}
				
		}

		for(int j = value-1; j>=0;j--)
		{
			
			System.out.print(arr[j]+" ");
		}

	}

}
