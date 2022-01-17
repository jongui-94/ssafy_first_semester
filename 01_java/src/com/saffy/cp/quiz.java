package com.saffy.cp;
import java.util.Scanner;

public class quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요. ");
		int com_num=0, user_num=0, pan;
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
			
			user_num = user_num % 3;
			com_num = com_num % 3;
			
			
			
		
		}
		
		
		

	}

}
