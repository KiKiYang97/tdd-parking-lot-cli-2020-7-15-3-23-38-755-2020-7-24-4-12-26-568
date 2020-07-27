package com.oocl.cultivation;

import java.util.ArrayList;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:02   2020/7/26
 * @ClassName ParkingBoy
 */
public interface ParkingBoy {
    Car fetchCar(CarTicket ticket);

    CarTicket parkCar(Car car);

    void parkMultipleCars(ArrayList<Car> list);
}
