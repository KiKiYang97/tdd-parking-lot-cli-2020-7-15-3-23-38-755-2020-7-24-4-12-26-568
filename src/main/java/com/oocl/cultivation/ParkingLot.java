package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingLotMap;
    private int capacity;

    public ParkingLot() {
        this.capacity = 10;
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (this.parkingLotMap.size() < this.capacity)
            return null;
        CarTicket ticket = new CarTicket();
        parkingLotMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingLotMap.remove(ticket);
    }
}
