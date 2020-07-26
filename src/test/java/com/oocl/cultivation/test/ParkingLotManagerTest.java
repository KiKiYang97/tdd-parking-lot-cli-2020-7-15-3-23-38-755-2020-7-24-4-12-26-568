package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:47   2020/7/26
 * @ClassName ParkingLotManagerTest
 */
public class ParkingLotManagerTest {
    @Test
    void should_add_parking_boy_when_manager_manage_parking_lot() {
//        given
        ParkingLot firstLot = new ParkingLot();
        ParkingLot secondLot = new ParkingLot();
        ParkingLot thirdLot = new ParkingLot();
        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
        lotArrayList.add(firstLot);
        lotArrayList.add(secondLot);
        ParkingBoy smartBoy = new SmartParkingBoyImpl(lotArrayList);
        ParkingBoy superSmartBoy = new SuperSmartParkingBoyImpl(thirdLot);
//        when
        ParkingLotManager manager = new ParkingLotManager();
        ParkingLot fourthLot = new ParkingLot();
        fourthLot.setManager(manager);
//        then
        manager.addParkingBoy(smartBoy);
        final List<ParkingBoy> parkingBoyList = manager.getParkingBoyList();
        final boolean flag = parkingBoyList.contains(smartBoy);
        assertTrue(flag);
    }
}
