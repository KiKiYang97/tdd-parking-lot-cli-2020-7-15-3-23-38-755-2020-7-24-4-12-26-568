package com.oocl.cultivation;

import java.util.ArrayList;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:07   2020/7/26
 * @ClassName BaseParkingBoy
 */
public abstract class BaseParkingBoy implements ParkingBoy {
    protected ArrayList<ParkingLot> parkingLots;


    public BaseParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Car fetchCar(CarTicket ticket) {
        if (ticket == null || !ticket.getClass().equals(CarTicket.class)) {
            throw new RuntimeException("Please provide your parking ticket.");
        }
        Car car = null;
        for (int i = 0; i < parkingLots.size(); i++) {
            car = parkingLots.get(i).fetch(ticket);
            if (car != null) {
                break;
            }
        }
        if (car == null) {
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return car;
    }

    @Override
    public CarTicket parkCar(Car car) {
        CarTicket carTicket = null;
        for (int i = 0; i < parkingLots.size(); i++) {
            carTicket = parkingLots.get(i).park(car);
            if (carTicket != null) {
                break;
            }
        }
        if (carTicket == null) {
            throw new RuntimeException("Not enough position.");
        }
        return carTicket;
    }

    @Override
    public abstract CarTicket parkCarWithMoreParkingLots(Car car);
}
