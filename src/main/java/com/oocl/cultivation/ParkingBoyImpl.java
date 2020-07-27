package com.oocl.cultivation;

import java.util.ArrayList;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 18:23   2020/7/26
 * @ClassName ParkingBoy
 */
public class ParkingBoyImpl extends BaseParkingBoy {

    public ParkingBoyImpl(ArrayList<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
    }

    @Override
    public CarTicket parkCarWithMoreParkingLots(Car car) {
        CarTicket carTicket = null;
        for (int i = 0; i < parkingLots.size(); i++) {
            int remainingCapacity = parkingLots.get(i).getRemainingCapacity();
            if (remainingCapacity>0){
                carTicket = parkingLots.get(i).park(car);
                break;
            }
        }
        return carTicket;
    }


}
