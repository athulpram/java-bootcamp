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

    @Test
    void shouldNotifyAssitantWhenCarIsParked() throws ParkingLotFullException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",10);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        DummyAssistant dummyAssistant = DummyAttendant.assistant;

        parkingLot.park(car);

        assertTrue(dummyAssistant.isNotifiedPark);
    }

    @Test
    void shouldNotifyAssitantWhenCarIsUnParked() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",10);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        DummyAssistant dummyAssistant = DummyAttendant.assistant;

        parkingLot.park(car);
        parkingLot.unpark(10);

        assertTrue(dummyAssistant.isNotifiedUnPark);
    }

    @Test
    void shouldNotifyAttendantWhenTheLotIsLessThanOrEqualToTwentyPercentWhileParking() throws ParkingLotFullException{
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",6);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.park(car);
        assertTrue(dummyAttendant.isTwentyPercent);
    }

    @Test
    void shouldNotNotifyAttendantWhenTheLotIsLessThanOrEqualToTwentyPercentWhileParking() throws ParkingLotFullException{
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.park(car);
        assertFalse(dummyAttendant.isTwentyPercent);
    }

    @Test
    void shouldNotNotifyAttendantWhenTheLotIsLessThanOrEqualToTwentyPercentWhileUnparking() throws ParkingLotFullException, CarNotFoundException {
        Car car = new Car(10);
        ParkingLot parkingLot = new ParkingLot("abc",1);
        DummyAttendant dummyAttendant = new DummyAttendant(parkingLot);
        parkingLot.park(car);
        parkingLot.unpark(10);
        assertTrue(dummyAttendant.isTwentyPercent);
    }
}

class DummyAttendant extends Attendant{
    boolean isNotifiedFull = false;
    boolean isNotifiedSpace = false;
    boolean isTwentyPercent = false;
    static DummyAssistant assistant = new DummyAssistant();

    DummyAttendant(ParkingLot parkingLot) {
        super(parkingLot,Display.getInstance(),assistant);
    }

    @Override
    public void notifyParkingLotFull(ParkingLot parkingLot) {
        isNotifiedFull = true;
    }

    @Override
    public void notifyParkingLotHasSpace(ParkingLot parkingLot) {
        isNotifiedSpace = true;
    }

    @Override
    public void notifyLessThanTwentyPercent(ParkingLot parkingLot) {
        isTwentyPercent = true;
    }
}

class DummyAssistant extends Assistant {
    boolean isNotifiedPark = false;
    boolean isNotifiedUnPark = false;


    @Override
    public void notifyParking(ParkingLot parkingLot) {
        this.isNotifiedPark = true;
    }

    @Override
    public void notifyUnParking(ParkingLot parkingLot) {
        this.isNotifiedUnPark = true;
    }
}