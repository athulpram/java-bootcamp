package com.step.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldReturnTheParkingPlaceNumberWhenACarParked() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        Attendant attendant = new Attendant(parkingLot);
        assertEquals(0,attendant.park(car));
    }

    @Test
    void shouldThrowParkingLotFullExceptionIfNoLotToPark() {
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(0);
        Attendant attendant = new Attendant(parkingLot);
        assertThrows(ParkingLotFullException.class,()->{attendant.park(car);});
    }

    @Test
    void shouldParkTheCarIfAnyOfTheLotIsAvailable() throws ParkingLotFullException {
        Car car = new Car(1);
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot1);
        parkingLot1.registerAttendant(attendant);
        parkingLot2.registerAttendant(attendant);
        attendant.addParkingLot(parkingLot2);
        assertEquals(0,attendant.park(car));
    }

    @Test
    void shouldThrowParkingLotFullExceptionIfNoneOfTheLotIsAvailableToPark(){
        Car car = new Car(1);
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Attendant attendant = new Attendant(parkingLot1);
        attendant.addParkingLot(parkingLot2);
        assertThrows(ParkingLotFullException.class,()->{attendant.park(car);});
    }

}