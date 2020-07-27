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
public class ParkingLotManager extends BaseParkingBoy {
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();

    public ParkingLotManager(ParkingLot parkingLot) {
        super(parkingLot);
    }

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
    public void parkMultipleCars(ArrayList<Car> list) {
        int size = list.size();
        int index = 0;
        for (int i = 0; i < parkingLotArrayList.size()&&size>0; i++) {
            int remainingCapacity = parkingLotArrayList.get(i).getRemainingCapacity();
            if (remainingCapacity > size){
                for (int j = index; j < index+size ; j++) {
                    parkingLotArrayList.get(i).park(list.get(j));
                }
            }else{
                for (int j = index; j < remainingCapacity ; j++) {
                    parkingLotArrayList.get(i).park(list.get(j));
                    index = j;
                    size--;
                }
            }
        }
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

    public Car specifyParkingBoyFetchCar(BaseParkingBoy boy, CarTicket carTicket) {
        final ArrayList<ParkingLot> list = boy.getParkingLotArrayList();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getManager()!= null && list.get(i).getManager().equals(this)){
                return boy.fetchCar(carTicket);
            }
        }
        return null;
    }
}
