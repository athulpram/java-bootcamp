package com.step.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

class Attendant {
    private Map<ParkingLot,Boolean> parkingLots;

    Attendant(ParkingLot parkingLot) {
        this.parkingLots = new HashMap<>();
        this.parkingLots.put(parkingLot,parkingLot.isAvailable());
    }

    void addParkingLot(ParkingLot parkingLot){
        this.parkingLots.put(parkingLot,parkingLot.isAvailable());
    }

    private ParkingLot getAvailableParkingLot() throws ParkingLotFullException {
        for(Map.Entry<ParkingLot, Boolean> parkingLotData: parkingLots.entrySet()){
            if(parkingLotData.getValue()){
                return parkingLotData.getKey();
            }
        }
        throw new ParkingLotFullException();
    }

    void updateParkingLotAvailability(ParkingLot parkingLot,boolean status){
        parkingLots.replace(parkingLot,status);
    }

    int park(Car car) throws ParkingLotFullException {
        ParkingLot parkingLot = getAvailableParkingLot();
        return parkingLot.park(car);
    }
}
