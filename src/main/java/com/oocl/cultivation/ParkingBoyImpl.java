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
    public void parkMultipleCars(ArrayList<Car> list) {
        int size = list.size();
        int index = 0;
        for (int i = 0; i < parkingLots.size()&&size>0; i++) {
            int remainingCapacity = parkingLots.get(i).getRemainingCapacity();
            if (remainingCapacity > size){
                for (int j = index; j < index+size ; j++) {
                    parkingLots.get(i).park(list.get(j));
                }
            }else{
                for (int j = index; j < remainingCapacity ; j++) {
                    parkingLots.get(i).park(list.get(j));
                    index = j;
                    size--;
                }
            }
        }
    }


}
