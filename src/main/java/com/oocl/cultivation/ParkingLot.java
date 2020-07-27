package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Comparable<ParkingLot> {
    private Map<CarTicket, Car> parkingLotMap;
    private int capacity;
    private int remainingCapacity;
    private ParkingLotManager manager;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLotManager getManager() {
        return manager;
    }

    public void setManager(ParkingLotManager manager) {
        this.manager = manager;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public CarTicket park(Car car) {
        if (this.remainingCapacity==0)
            return null;
        CarTicket ticket = new CarTicket();
        parkingLotMap.put(ticket, car);
        this.remainingCapacity--;
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingLotMap.remove(ticket);
    }


    @Override
    public int compareTo(ParkingLot o) {
        return o.remainingCapacity - this.remainingCapacity;
    }
}
