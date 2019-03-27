package com.step.bootcamp.parkinglot;

import java.util.HashMap;

class Attendant implements ParkingLotAttendant {
    boolean isTwentyPercent = false;
    private HashMap<ParkingLot, Boolean> parkingLots;
    private Display plDisplay;
    private ParkingLotAssistant assistant;

    Attendant(ParkingLot parkingLot, Display plDisplay, ParkingLotAssistant assistant) {
        this.assistant = assistant;
        this.parkingLots = new HashMap<>();
        this.plDisplay = plDisplay;
        this.addParkingLot(parkingLot);
    }

    void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.put(parkingLot, parkingLot.isAvailable());
        parkingLot.registerAttendant(this);
        parkingLot.registerAssistant(this.assistant);
//        plDisplay.updateDisplay(parkingLot.getName(), parkingLot.getNumberOfCars());
    }

    public void notifyParkingLotFull(ParkingLot parkingLot) {
        parkingLots.replace(parkingLot, true);
    }


    public void notifyParkingLotHasSpace(ParkingLot parkingLot) {
        parkingLots.replace(parkingLot, false);
    }


    public void notifyLessThanTwentyPercent(ParkingLot parkingLot){
        System.out.println("Promoting the parking lot through ads.......");
    }
}
