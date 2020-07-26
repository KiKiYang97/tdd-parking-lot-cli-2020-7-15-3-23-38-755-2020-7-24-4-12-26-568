package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:07   2020/7/26
 * @ClassName BaseParkingBoy
 */
public abstract class BaseParkingBoy implements ParkingBoy {
    protected ParkingLot parkingLot;
    protected ArrayList<ParkingLot> parkingLotArrayList;
    protected PriorityQueue<ParkingLot> parkingLotQueue;

    public BaseParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public BaseParkingBoy(ArrayList<ParkingLot> parkingLotArrayList) {
        parkingLotQueue = new PriorityQueue<>();
        parkingLotQueue.addAll(parkingLotArrayList);
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public ArrayList<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }

    @Override
    public String fetchCar(CarTicket ticket) {
        if(ticket==null||!ticket.getClass().equals(CarTicket.class)){
            return "Please provide your parking ticket.";
        }
        if (parkingLot.fetch(ticket)==null){
            return "Unrecognized parking ticket.";
        }
        return null;
    }

    @Override
    public String parkCar(Car car) {
        if(parkingLot.park(car)==null){
            return "Not enough position.";
        }
        return "";
    }

    @Override
    public abstract void parkMultipleCars(ArrayList<Car> list);
}
