package com.oocl.cultivation;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:49   2020/7/26
 * @ClassName ParkingLotManager
 */
public class ParkingLotManager implements ParkingBoy {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    @Override
    public String fetchCar(CarTicket ticket) {
        return null;
    }

    @Override
    public String parkCar(Car car) {
        return null;
    }

    @Override
    public void parkMultipleCars(ArrayList<Car> list) {

    }

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    public ParkingBoy setSpecifyParkingBoy(BaseParkingBoy smartBoy) {
        final ArrayList<ParkingLot> list = smartBoy.getParkingLotArrayList();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getManager()!= null && list.get(i).getManager().equals(this)){
                return smartBoy;
            }
        }
        return this;
    }
}
