package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:12   2020/7/26
 * @ClassName SmartParkingBoyImpl
 */
public class SmartParkingBoyImpl extends BaseParkingBoy{

    public SmartParkingBoyImpl(ArrayList<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        parkingLotQueue = new PriorityQueue<>(new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o2.getRemainingCapacity()-o1.getRemainingCapacity();
            }
        });
        parkingLotQueue.addAll(parkingLotArrayList);
    }

    @Override
    public CarTicket parkCarWithMoreParkingLots(Car car) {
        CarTicket carTicket = null;
        for (int i = 0; i < parkingLotQueue.size() ; i++) {
            ParkingLot parkingLot = parkingLotQueue.poll();
            int remainingCapacity = parkingLot.getRemainingCapacity();
            if (remainingCapacity>0){
                carTicket = parkingLot.park(car);
                break;
            }
        }
        return carTicket;
    }
}
