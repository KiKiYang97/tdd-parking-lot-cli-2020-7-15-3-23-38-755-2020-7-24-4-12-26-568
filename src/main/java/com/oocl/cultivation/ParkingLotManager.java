package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dunka
 * @Description //TODO
 * @Date 22:49   2020/7/26
 * @ClassName ParkingLotManager
 */
public class ParkingLotManager extends BaseParkingBoy {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();


    public ParkingLotManager(ArrayList<ParkingLot> lotArrayList) {
        super(lotArrayList);
    }


    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    @Override
    public Car fetchCar(CarTicket ticket) {
        return null;
    }

    @Override
    public CarTicket parkCar(Car car) {
        return null;
    }

    @Override
    public CarTicket parkCarsSequentially(Car car) {
        CarTicket carTicket = null;
        for (int i = 0; i < parkingLots.size(); i++) {
            int remainingCapacity = parkingLots.get(i).getRemainingCapacity();
            if (remainingCapacity>0){
                carTicket = parkingLots.get(i).park(car);
            }
        }
        return carTicket;
    }

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    public ParkingBoy setSpecifyParkingBoy(BaseParkingBoy smartBoy) {
        final ArrayList<ParkingLot> list = smartBoy.getParkingLots();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getManager()!= null && list.get(i).getManager().equals(this)){
                return smartBoy;
            }
        }
        return this;
    }

    public Car specifyParkingBoyFetchCar(BaseParkingBoy boy, CarTicket carTicket) {
        final ArrayList<ParkingLot> list = boy.getParkingLots();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getManager()!= null && list.get(i).getManager().equals(this)){
                return boy.fetchCar(carTicket);
            }
        }
        return null;
    }
}
