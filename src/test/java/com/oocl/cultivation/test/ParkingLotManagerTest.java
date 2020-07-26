package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_parking_boy_when_manager_manege_lot_given_parking_lot() {
        //        given
        ParkingLot firstLot = new ParkingLot();
        ParkingLot secondLot = new ParkingLot();
        ParkingLot thirdLot = new ParkingLot();
        ParkingLot fourthLot = new ParkingLot();
        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
        lotArrayList.add(firstLot);
        lotArrayList.add(secondLot);
        lotArrayList.add(thirdLot);
        ParkingBoy smartBoy = new SmartParkingBoyImpl(lotArrayList);
        ParkingBoy superSmartBoy = new SuperSmartParkingBoyImpl(fourthLot);
//        when
        ParkingLotManager manager = new ParkingLotManager();
        fourthLot.setManager(manager);
        manager.addParkingBoy(smartBoy);
        manager.addParkingBoy(superSmartBoy);
//        then
        ParkingBoy boy = manager.setSpecifyParkingBoy(superSmartBoy);
        ParkingBoy boy2 = manager.setSpecifyParkingBoy(smartBoy);
       assertEquals(superSmartBoy,boy);
       assertEquals(manager,boy2);
    }
}