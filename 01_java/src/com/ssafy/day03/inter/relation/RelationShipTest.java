package com.ssafy.day03.inter.relation;

/**
 * @since 2021. 7. 7.
 */
public class RelationShipTest {
    public static void main(String[] args) {
        Chargeable[] objs = {new HandPhone(), new DigitalCamera()};
        
        for(Chargeable obj: objs) {
        	obj.charge();
        }
    }

}
