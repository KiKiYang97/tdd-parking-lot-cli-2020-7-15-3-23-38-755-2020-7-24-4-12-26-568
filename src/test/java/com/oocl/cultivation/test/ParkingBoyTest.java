package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
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

    @Test
    void should_return_unrecognized_message_when_fetch_car_given_used_ticket() {
//        given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        when
        CarTicket carTicket = parkingLot.park(car);
        parkingLot.fetch(carTicket);
//        then
        String message = parkingBoy.fetchCar(carTicket);
        assertEquals("Unrecognized parking ticket.",message);
    }

    @Test
    void should_return_provide_message_when_fetch_car_given_no_ticket() {
//        given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        when
        final String message = parkingBoy.fetchCar(null);
//        then
        assertEquals("Please provide your parking ticket.",message);
    }

    @Test
    void should_return_position_message_when_park_car_given_not_enough_position() {
//        given
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < 10 ; i++) {
            parkingLot.park(new Car());
        }
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
//        when
        String message = parkingBoy.parkCar(car);
//        then
        assertEquals("Not enough position.",message);
    }
}
