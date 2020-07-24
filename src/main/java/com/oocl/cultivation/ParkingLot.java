package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket,Car> parkingLotMap = new HashMap<CarTicket,Car>();
    public CarTicket park(Car car) {
        if (this.parkingLotMap.size()==10)
            return null;
        CarTicket ticket = new CarTicket();
        parkingLotMap.put(ticket,car);
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingLotMap.remove(ticket);
    }
}
