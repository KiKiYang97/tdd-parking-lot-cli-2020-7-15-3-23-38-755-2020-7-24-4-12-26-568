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
    public Car fetchCar(CarTicket ticket) {
        if(ticket==null||!ticket.getClass().equals(CarTicket.class)){
            throw new RuntimeException( "Please provide your parking ticket.");
        }
        Car car = parkingLot.fetch(ticket);
        if (car==null){
            throw new RuntimeException( "Unrecognized parking ticket.");
        }
        return car;
    }

    @Override
    public CarTicket parkCar(Car car) {
        CarTicket carTicket = parkingLot.park(car);
        if(carTicket==null){
            throw new RuntimeException("Not enough position.");
        }
        return carTicket;
    }

    @Override
    public abstract void parkMultipleCars(ArrayList<Car> list);
}
