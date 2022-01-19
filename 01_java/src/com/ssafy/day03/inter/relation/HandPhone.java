package com.ssafy.day03.inter.relation;

/**
 * @since 2021. 7. 7.
 */
public class HandPhone extends Phone implements Chargeable {

	@Override
	public void charge() {
		// TODO Auto-generated method stub
		System.out.println("핸드폰 충전중");
	}
    // TODO: Chargeable을 구현하시오.
    // END:
}
