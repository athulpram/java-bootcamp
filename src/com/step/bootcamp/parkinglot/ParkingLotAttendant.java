package com.step.bootcamp.parkinglot;

interface ParkingLotAttendant {
    void notifyParkingLotFull(ParkingLot parkingLot);
    void notifyParkingLotHasSpace(ParkingLot parkingLot);
    void notifyLessThanTwentyPercent(ParkingLot parkingLot);
}
