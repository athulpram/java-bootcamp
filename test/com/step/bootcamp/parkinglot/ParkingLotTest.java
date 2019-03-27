package com.step.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldReturnTheParkingPlaceNumberWhenACarParked() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot("abc",10);
        assertEquals(0,parkingLot.park(car));
    }

    @Test
    void shouldThrowParkingLotFullExceptionIfNoLotToPark() {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot("abc",0);
        assertThrows(ParkingLotFullException.class,()->{parkingLot.park(car);});
    }

    @Test
    void shouldInformAttendantWhenACarIsParked() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot("abc",1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.park(car);
        assertTrue(dummyAttendant.isNotifiedFull);
    }

    @Test
    void shouldUnParkTheCarWhenKeyIsPassed() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",1);
        parkingLot.park(car);
        assertEquals(car,parkingLot.unpark(10));
    }

    @Test
    void shouldNotifyAttenderWhenParkingLotIsUpdatedByUnParking() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.park(car);
        parkingLot.unpark(10);
        assertTrue(dummyAttendant.isNotifiedSpace);
    }
}

class DummyAttendant extends Attendant{
    boolean isNotifiedFull = false;
    boolean isNotifiedSpace = false;
    DummyAttendant(ParkingLot parkingLot) {
        super(parkingLot,Display.getInstance());
    }
    @Override
    void notifyParkingLotFull(ParkingLot parkingLot) {
        isNotifiedFull = true;
    }

    @Override
    void notifyParkingLotHasSpace(ParkingLot parkingLot) {
        isNotifiedSpace = true;
    }
}