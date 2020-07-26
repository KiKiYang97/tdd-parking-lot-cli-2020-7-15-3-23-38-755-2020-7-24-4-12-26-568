package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:17   2020/7/26
 * @ClassName SuperSmartParkingBoyImpl
 */
public class SuperSmartParkingBoyImpl extends BaseParkingBoy{
    public SuperSmartParkingBoyImpl(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoyImpl(ArrayList<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        parkingLotQueue = new PriorityQueue<>(new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                final float v1 = 1.0f * o1.getRemainingCapacity() / 1.0f * o1.getCapacity();
                final float v2 = 1.0f * o2.getRemainingCapacity() / 1.0f * o2.getCapacity();
                if(v2>v1){
                    return 1;
                }else if(v2<v1){
                    return -1;
                }else{
                    return 0;
                }
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