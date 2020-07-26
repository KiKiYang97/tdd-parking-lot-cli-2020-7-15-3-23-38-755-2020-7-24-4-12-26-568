package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 18:16   2020/7/26
 * @ClassName ParkingBoyTest
 */
public class ParkingBoyTest {
    @Test
    void should_return_unrecognized_message_when_fetch_car_given_wrong_ticket() {
//        given
        CarTicket ticket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy(parkingLot);
//        when
        String message = boy.fetchCar(ticket);
//        then
        assertEquals("Unrecognized parking ticket.",message);
    }
}
