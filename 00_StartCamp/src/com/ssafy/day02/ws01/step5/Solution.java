/*
 *  데일리 실습_Java_01_5
 *  Java 01. 2차원배열 응용
 *  
 */
package com.ssafy.day02.ws01.step5;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ws01_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int scale, max=0;
				
			scale = Integer.parseInt(in.readLine());
			scale += 2;
			int[][] street = new int[scale][scale];
			
			String s;
			for(int i=1; i<scale-1;i++)
			{
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j=1; j<scale-1;j++)
				{
					s = st.nextToken();
					if(s.equals("G"))
						street[i][j] = 1;
					else if(s.equals("B"))
						street[i][j] = 0;
				}
			}
			
			for(int i=1; i<scale-1;i++)
			{
				for(int j=1; j<scale-1;j++)
				{
					int value =0;
					if(check(i,j,street))
						{
							value = height(i,j,scale, street);
							if(value > max)
								max = value;
						}
				}
			}
			System.out.print("#" + test_case + " ");
			System.out.println(max);
				
		}
	}
	static boolean check(int i, int j, int[][] street)
	{
		int sum=0;
		for(int a=i-1;a<i+2;a++)
		{
			for(int b=j-1;b<j+2;b++)
			{
				sum += street[a][b];
			}
		}
		if(sum==0)
			return true;
		else
			return false;
			
	}
	static int height(int i, int j, int scale, int[][] street)
	{
		int now=0;
		int stack=0;
		int hei = 0;
		for(int a=1;a<scale-1;a++)
		{
			now += street[i][a];
			stack +=1;
		}
		for(int a=1;a<scale-1;a++)
		{
			now += street[a][j];
			stack +=1;
		}
		hei = stack - now-1;
		return hei;
	}
	

}
