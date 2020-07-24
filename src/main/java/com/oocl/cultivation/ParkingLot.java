package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket,Car> parkingLotMap = new HashMap<CarTicket,Car>();
    public CarTicket park(Car car) {
        CarTicket ticket = new CarTicket();
        parkingLotMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingLotMap.get(ticket);
    }
}
