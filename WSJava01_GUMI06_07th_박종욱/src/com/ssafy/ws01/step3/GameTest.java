package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요. ");
		int com_num=0, user_num=0, pan;
		int st=0;
		String user;
		pan = sc.nextInt();
		if(pan == 1)
			pan = 5;
		else if(pan == 2)
			pan = 3;
		else if(pan == 3)
			pan = 1;
		
		for(int i =1;i<=pan;i++)
		{
			System.out.println("가위바위보 중 하나 입력: ");
			user = sc.next();
			if(user.equals("가위"))
				user_num = 1;
			else if(user.equals("바위"))
				user_num = 2;
			else if(user.equals("보"))
				user_num = 3;
			com_num = (int)(Math.random() * 3) + 1;
			
			if(com_num == user_num)
				System.out.println("비겼습니다!!");
			else if(user_num-1 == com_num%3)
			{
				System.out.println("이겼습니다!!");
				st++;
			}
			else
			{
				System.out.println("졌습니다!!");
				st--;
			}
		}
		if(st==0)
			System.out.println("### 비겼습니다!!!");
		else if(st>0)
			System.out.println("### 유저승리!!!");
		else
			System.out.println("### 컴퓨터 승!!!");
		

	}

}