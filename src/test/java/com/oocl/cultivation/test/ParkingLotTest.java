package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_car_ticket_when_park_car_given_car() {
//    given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
//    when
        CarTicket ticket = parkingLot.park(car);
//    then
        assertNotNull(ticket);
    }
}
