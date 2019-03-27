package com.step.bootcamp.parkinglot;

import java.util.HashMap;

class Attendant {
    private HashMap<ParkingLot,Boolean> parkingLots;
    private Display plDisplay;

    Attendant(ParkingLot parkingLot, Display plDisplay) {
        this.parkingLots = new HashMap<>();
        this.plDisplay = plDisplay;
        this.addParkingLot(parkingLot);
    }

    void addParkingLot(ParkingLot parkingLot){
        this.parkingLots.put(parkingLot,parkingLot.isAvailable());
        parkingLot.registerAttendant(this);
        plDisplay.updateDisplay(parkingLot.getName(),parkingLot.getNumberOfCars());
    }
//
//    void updateParkingLotAvailability(ParkingLot parkingLot,boolean status,Integer size){
//        parkingLots.replace(parkingLot,status);
//    }

    void notifyParkingLotFull(ParkingLot parkingLot){
        parkingLots.replace(parkingLot,true);
    }


    void notifyParkingLotHasSpace(ParkingLot parkingLot){
        parkingLots.replace(parkingLot,false);
    }


}
