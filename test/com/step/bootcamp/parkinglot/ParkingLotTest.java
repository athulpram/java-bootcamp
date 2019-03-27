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

    @Test
    void shouldUnParkTheCarWhenKeyIsPassed() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        assertEquals(car,parkingLot.unpark(10));
    }

    @Test
    void shouldNotifyAttenderWhenParkingLotGotSpaceAfterBecomingFull() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot(1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.registerAttendant(dummyAttendant);
        parkingLot.park(car);
        parkingLot.unpark(10);
        assertTrue(dummyAttendant.isNotified);
    }
}

class DummyAttendant extends Attendant{
    boolean isNotified;
    DummyAttendant(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    void updateParkingLotAvailability(ParkingLot pl,boolean status){
        isNotified =status;
    }
}