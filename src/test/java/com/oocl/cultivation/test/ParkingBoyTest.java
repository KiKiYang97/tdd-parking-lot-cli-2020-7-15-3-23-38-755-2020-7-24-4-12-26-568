package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        ParkingBoy boy = new ParkingBoyImpl(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoyImpl(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoyImpl(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoyImpl(parkingLot);
        Car car = new Car();
//        when
        String message = parkingBoy.parkCar(car);
//        then
        assertEquals("Not enough position.",message);
    }

    @Test
    void should_sequentially_park_car_when_park_car_given_two_parking_lots() {
//        given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
        lotArrayList.add(firstParkingLot);
        lotArrayList.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoyImpl(lotArrayList);
//        when
        ArrayList<Car> list = new ArrayList<>();
        for (int i = 0; i <12 ; i++) {
            list.add(new Car());
        }
        parkingBoy.parkMultipleCars(list);
//        then
        assertEquals(0,firstParkingLot.getRemainingCapacity());
        assertEquals(8,secondParkingLot.getRemainingCapacity());
    }

    @Test
    void should_park_car_in_more_empty_position_when_park_car_given_two_parking_lot() {
        //        given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
//        when
        for (int i = 0; i < 4 ; i++) {
            firstParkingLot.park(new Car());
        }
        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
        lotArrayList.add(firstParkingLot);
        lotArrayList.add(secondParkingLot);
        ParkingBoy parkingBoy = new SmartParkingBoyImpl(lotArrayList);
        ArrayList<Car> list = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            list.add(new Car());
        }
        parkingBoy.parkMultipleCars(list);
//        then
        assertEquals(6,firstParkingLot.getRemainingCapacity());
        assertEquals(4,secondParkingLot.getRemainingCapacity());
    }
}
