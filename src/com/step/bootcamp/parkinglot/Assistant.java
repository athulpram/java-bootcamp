package com.step.bootcamp.parkinglot;

public class Assistant implements ParkingLotAssistant {

    @Override
    public void notifyParking(ParkingLot parkingLot) {
        this.updateBoard(parkingLot);
    }

    private void updateBoard(ParkingLot parkingLot){
        Display display = Display.getInstance();
        display.updateDisplay(parkingLot.getName(),parkingLot.getNumberOfCars());
    }

    @Override
    public void notifyUnParking(ParkingLot parkingLot) {
        this.updateBoard(parkingLot);
    }
}
