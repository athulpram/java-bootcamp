package com.step.bootcamp.parkinglot;

import java.util.ArrayList;

class ParkingLot {
    private final ArrayList<Car> lots;
    private final int MAX_LOT_SIZE;
    private Attendant attendant = null;

    ParkingLot(int size) {
        this.lots = new ArrayList<>(size);
        this.MAX_LOT_SIZE = size;
    }

    void registerAttendant(Attendant attendant){
        this.attendant = attendant;
    }


    int park(Car car) throws ParkingLotFullException {
        if(!isAvailable()) {
            throw new ParkingLotFullException();
        }
        this.lots.add(car);
        if(!isAvailable() && this.attendant != null){
            attendant.updateParkingLotAvailability(this,false);
        }
        return lots.indexOf(car);
    }

    boolean isAvailable() {
        return !(lots.size()==MAX_LOT_SIZE);
    }


    Car unpark(int carKey) throws CarNotFoundException {
        boolean isFull = !this.isAvailable();
        for (Car car : this.lots) {
            if (car.isSameKey(carKey)){
                lots.remove(car);
                if(isFull && this.isAvailable() && this.attendant != null ){
                    attendant.updateParkingLotAvailability(this,true);
                }
                return car;
            }
        }
        throw new CarNotFoundException();
    }
}
