package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 18:23   2020/7/26
 * @ClassName ParkingBoy
 */
public class ParkingBoy {
    private ParkingLot parkingLot;
    private ArrayList<ParkingLot> parkingLotArrayList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public String fetchCar(CarTicket ticket) {
        if(ticket==null||!ticket.getClass().equals(CarTicket.class)){
            return "Please provide your parking ticket.";
        }
        if (parkingLot.fetch(ticket)==null){
            return "Unrecognized parking ticket.";
        }
        return null;
    }

    public String parkCar(Car car) {
        if(parkingLot.park(car)==null){
            return "Not enough position.";
        }
        return "";
    }

    public void parkMultipleCars(ArrayList<Car> list) {
        int size = list.size();
        int index = 0;
        for (int i = 0; i < parkingLotArrayList.size()&&size>0; i++) {
            int remainingCapacity = parkingLotArrayList.get(i).getRemainingCapacity();
            if (remainingCapacity > size){
                for (int j = index; j < index+size ; j++) {
                    parkingLotArrayList.get(i).park(list.get(j));
                }
            }else{
                for (int j = index; j < remainingCapacity ; j++) {
                    parkingLotArrayList.get(i).park(list.get(j));
                    index = j;
                    size--;
                }
            }
        }
    }
}
