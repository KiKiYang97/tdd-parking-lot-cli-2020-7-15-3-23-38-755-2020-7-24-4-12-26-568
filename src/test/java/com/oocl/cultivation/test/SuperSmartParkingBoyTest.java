package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoyImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_park_car_in_large_position_rate_when_park_car_given_two_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot(2);
//        when
        for (int i = 0; i < 6 ; i++) {
            firstParkingLot.park(new Car());
        }
        secondParkingLot.park(new Car());

        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
        lotArrayList.add(firstParkingLot);
        lotArrayList.add(secondParkingLot);
        ParkingBoy parkingBoy = new SuperSmartParkingBoyImpl(lotArrayList);


        parkingBoy.parkCarsSequentially(new Car());
//        then
        assertEquals(4,firstParkingLot.getRemainingCapacity());
        assertEquals(0,secondParkingLot.getRemainingCapacity());

    }
}
