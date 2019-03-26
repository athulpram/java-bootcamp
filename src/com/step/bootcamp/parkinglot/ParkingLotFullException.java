package com.step.bootcamp.parkinglot;

class ParkingLotFullException extends Exception{
    public ParkingLotFullException() {
        super("Parking Lot is Full");
    }
}
