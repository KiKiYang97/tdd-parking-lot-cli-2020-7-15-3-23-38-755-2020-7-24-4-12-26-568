package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:47   2020/7/26
 * @ClassName ParkingLotManagerTest
 */
public class ParkingLotManagerTest {
    @Test
    void should_park_car_when_manager_manage_parking_lot() {
//        given
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> lots = new ArrayList<>();
        lots.add(parkingLot);
        ParkingBoyImpl  parkingBoy = new ParkingBoyImpl(lots);

        ParkingLot secondParkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> secondLots = new ArrayList<>();
        lots.add(secondParkingLot);
        SmartParkingBoyImpl  smartParkingBoy = new SmartParkingBoyImpl(secondLots);

        ParkingLot thirdParkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> thirdLots = new ArrayList<>();
        lots.add(thirdParkingLot);
        ParkingLotManager manager = new ParkingLotManager(thirdLots);
        manager.addParkingBoy(parkingBoy);
        manager.addParkingBoy(smartParkingBoy);
//        when
         manager.parkCar(new Car());
         manager.parkCar(new Car());
         manager.parkCar(new Car());

         assertEquals(0,parkingLot.getRemainingCapacity());
         assertEquals(0,secondParkingLot.getRemainingCapacity());
         assertEquals(0,thirdParkingLot.getRemainingCapacity());

    }

    @Test
    void should_return_parking_boy_when_manager_manege_lot_given_parking_lot() {
        //        given
//        ParkingLot firstLot = new ParkingLot();
//        ParkingLot secondLot = new ParkingLot();
//        ParkingLot thirdLot = new ParkingLot();
//        ParkingLot fourthLot = new ParkingLot();
//        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
//        lotArrayList.add(firstLot);
//        lotArrayList.add(secondLot);
//        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
//        parkingLotArrayList.add(thirdLot);
//        parkingLotArrayList.add(fourthLot);
//        BaseParkingBoy smartBoy = new SmartParkingBoyImpl(lotArrayList);
//        BaseParkingBoy superSmartBoy = new SuperSmartParkingBoyImpl(parkingLotArrayList);
////        when
//        ParkingLotManager manager = new ParkingLotManager(new ArrayList<>());
//        fourthLot.setManager(manager);
//        manager.addParkingBoy(smartBoy);
//        manager.addParkingBoy(superSmartBoy);
////        then
//        ParkingBoy boy = manager.setSpecifyParkingBoy(superSmartBoy);
//        ParkingBoy boy2 = manager.setSpecifyParkingBoy(smartBoy);
//       assertEquals(superSmartBoy,boy);
//       assertEquals(manager,boy2);
    }

    @Test
    void should_sequentially_park_car_when_park_car_given_two_parking_lots() {
////        given
//        ParkingLot firstParkingLot = new ParkingLot();
//        ParkingLot secondParkingLot = new ParkingLot();
//        ArrayList<ParkingLot> lotArrayList = new ArrayList<>();
//        lotArrayList.add(firstParkingLot);
//        lotArrayList.add(secondParkingLot);
//        BaseParkingBoy manager = new ParkingLotManager(lotArrayList);
////        when
//        manager.parkCarWithMoreParkingLots(new Car());
////        then
//        assertEquals(0,firstParkingLot.getRemainingCapacity());
//        assertEquals(8,secondParkingLot.getRemainingCapacity());
    }

    @Test
    void should_return_wrong_message_when_manage_park_car_given_park_car() {
//        given
//        final ArrayList<ParkingLot> list = new ArrayList<>();
//        ParkingLot lot = new ParkingLot();
//        list.add(lot);
//        ParkingLotManager manager =new ParkingLotManager(list);
//        lot.setManager(manager);
////        when
//        CarTicket carTicket = new CarTicket();
//        BaseParkingBoy boy = new ParkingBoyImpl(list);
//        String message = manager.specifyParkingBoyFetchCar(boy,carTicket);
////        then
//        assertEquals("Unrecognized parking ticket.",message);
    }
}
