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
			int height = 0;
			System.out.print("#" + test_case + " ");	
			
			int scale;
			scale = Integer.parseInt(in.readLine());
			int[][] street = new int[scale][scale];
			String s;
			for(int i=0; i<scale;i++)
			{
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j=0; j<scale;j++)
				{
					s = st.nextToken();
					System.out.println(s);
					if(s.equals("G"))
						street[i][j] = 0;
					else if(s.equals("B"))
						street[i][j] = 1;
				}
			}
			
			for(int i=0; i<scale;i++)
			{
				for(int j=0; j<scale;j++)
				{
					System.out.println(street[i][j]);
				}
			}
			
			
		
		
		
		}
	}
	

}
