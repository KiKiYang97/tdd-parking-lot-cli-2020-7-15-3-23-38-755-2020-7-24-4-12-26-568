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

    public SmartParkingBoyImpl(ParkingLot parkingLot) {
        super(parkingLot);
    }

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
    public void parkMultipleCars(ArrayList<Car> list) {
        int size = list.size();
        int index = 0;
        for (int i = 0; i < parkingLotQueue.size() && size > 0; i++) {
            ParkingLot parkingLot = parkingLotQueue.poll();
            int remainingCapacity = parkingLot.getRemainingCapacity();
            if (remainingCapacity > size) {
                for (int j = index; j < index + size; j++) {
                    parkingLot.park(list.get(j));
                }
            } else {
                for (int j = index; j < remainingCapacity; j++) {
                    parkingLot.park(list.get(j));
                    index = j;
                    size--;
                }
            }
        }
    }
}