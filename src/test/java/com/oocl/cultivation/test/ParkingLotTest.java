package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.concurrent.locks.LockSupport;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_fetch_car_when_fetch_car_given_car_ticket() {
//        given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
//        when
        CarTicket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
//        then
        assertNotNull(ticket);
        assertEquals(car,fetchedCar);
    }

    @Test
    void should_fetch_right_car_when_park_multiple_cars_given_correspond_ticket() {
//        given
        Car firstCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Car secondCar = new Car();
//        when
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        Car fetchedFirstCar = parkingLot.fetch(firstCarTicket);
        CarTicket secondCarTicket = parkingLot.park(secondCar);
        Car fetchedSecondCar = parkingLot.fetch(secondCarTicket);
//        then
        assertEquals(firstCar,fetchedFirstCar);
        assertEquals(secondCar,fetchedSecondCar);
    }

    @Test
    void should_fetched_no_car_when_fetch_car_given_wrong_ticket() {
//        given
        CarTicket ticket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
//        when
        Car fetchedCar = parkingLot.fetch(ticket);
//        then
        assertNull(fetchedCar);
    }

    @Test
    void should_fetch_no_car_when_fetch_car_given_no_ticket() {
//        given
        ParkingLot parkingLot = new ParkingLot();
//        when
        Car fetchedCar = parkingLot.fetch(null);
//        then
        assertNull(fetchedCar);
    }

    @Test
    void should_fetch_no_car_when_fetch_car_given_used_ticket() {
//        given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
//        when
        CarTicket carTicket = parkingLot.park(car);
        parkingLot.fetch(carTicket);
//        then
        Car fetchCar = parkingLot.fetch(carTicket);
        assertNull(fetchCar);
    }

    @Test
    void should_can_not_park_when_park_car_given_parking_lot_has_no_position() {
//        given
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i <10 ; i++) {
            parkingLot.park(new Car());
        }
//        when
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);
//        then
        assertNull(carTicket);
    }
}
