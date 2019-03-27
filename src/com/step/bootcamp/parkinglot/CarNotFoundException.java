package com.step.bootcamp.parkinglot;

class CarNotFoundException extends Exception {
    CarNotFoundException() {
        super("Are you sure that you parked your car here?");
    }
}
