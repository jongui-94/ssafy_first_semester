package com.ssafy.day02.ex02.encapsulation;

class UnbelievableUserInfo {
	//이름은 null이 될 수 없음.
	private String name = "홍길동";
	
	// 계좌는 0보다 커야 함.
	private int account = 10000;
	
	// TODO: name 과 account에 부적절한 값이 할당되지 못하도록 처리하시오.
    // END:
	
	//Getter
	public String getName()
	{
		return this.name;
	}
	//Setter
	public void setName(String name)
	{
		if(name != null)
		{
			this.name = name;
		}
		else
		{
			System.out.println("부적절한 값이 입력되었습니다.");
		}
	}
	
	public int getAccount()
	{
		return this.account;
	}
	
	public void setAccount(int account)
	{
		if(account > 0)
		{
			this.account = account;
		}
		else
		{
			System.out.println("부적절한 계좌금액이 입력되었습니다.");
		}
	}
}

public class UnbelievableTest {
	
	public static void main(String[] args) {
		
		UnbelievableUserInfo info = new UnbelievableUserInfo();
		System.out.printf("사용자 정보:%s, %d%n", info.getName(), info.getAccount());
		
		info.setName(null);
		info.setAccount(-1000);
		System.out.printf("사용자 정보:%s, %d%n", info.getName(), info.getAccount());
		
		info.setName("이몽룡");
		info.setAccount(100000);
		System.out.printf("사용자 정보:%s, %d%n", info.getName(), info.getAccount());
	}
}