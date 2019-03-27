package com.step.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldReturnTheParkingPlaceNumberWhenACarParked() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        assertEquals(0,parkingLot.park(car));
    }

    @Test
    void shouldThrowParkingLotFullExceptionIfNoLotToPark() {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(0);
        assertThrows(ParkingLotFullException.class,()->{parkingLot.park(car);});
    }

    @Test
    void shouldInformAttendantWhenTheParkingLotIsFull() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.registerAttendant(dummyAttendant);
        parkingLot.park(car);
        assertFalse(dummyAttendant.isNotified);
    }
}

class DummyAttendant extends Attendant{
    boolean isNotified = true;
    DummyAttendant(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    void updateParkingLotAvailability(ParkingLot pl,boolean status){
        isNotified =status;
    }
}