package com.oocl.cultivation;

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
    private Map<ParkingLot,Integer> parkingLotIntegerMap;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(Map<ParkingLot, Integer> parkingLotIntegerMap) {
        this.parkingLotIntegerMap = parkingLotIntegerMap;
    }

    public String fetchCar(CarTicket ticket) {
        if(!ticket.getClass().equals(CarTicket.class)){
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

    public void parkMultipleCars(Set<Car> set) {
    }
}
