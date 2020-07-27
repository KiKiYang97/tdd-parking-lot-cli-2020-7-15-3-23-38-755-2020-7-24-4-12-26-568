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
    protected PriorityQueue<ParkingLot> parkingLotQueue;
    public SuperSmartParkingBoyImpl(ArrayList<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        parkingLotQueue = new PriorityQueue<>();
        parkingLotQueue.addAll(parkingLots);
        parkingLotQueue = new PriorityQueue<>(new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                final float v1 = 1.0f * o1.getRemainingCapacity() / 1.0f * o1.getCapacity();
                final float v2 = 1.0f * o2.getRemainingCapacity() / 1.0f * o2.getCapacity();
                if(v2>v1){
                    return -1;
                }else if(v2<v1){
                    return 1;
                }else{
                    return 0;
                }
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
