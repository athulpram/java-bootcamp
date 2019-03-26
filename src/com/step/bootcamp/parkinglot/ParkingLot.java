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

    private boolean isNotAvailable(){
        return lots.size()==MAX_LOT_SIZE;
    }

    int park(Car car) throws ParkingLotFullException {
        if(isNotAvailable()) {
            throw new ParkingLotFullException();
        }
        this.lots.add(car);
        if(isNotAvailable()){
            attendant.updateParkingLotAvailability(this,false);
        }
        return lots.indexOf(car);
    }

    boolean isAvailable() {
        return !isNotAvailable();
    }
}
