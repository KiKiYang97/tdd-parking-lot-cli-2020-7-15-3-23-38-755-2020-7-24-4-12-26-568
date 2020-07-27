package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoyImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
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
