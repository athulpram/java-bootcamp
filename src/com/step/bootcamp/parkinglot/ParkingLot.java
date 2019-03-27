package com.step.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private String name;
    private final ArrayList<Car> lots;
    private final int MAX_LOT_SIZE;
    private List<ParkingLotAttendant> attendants;
    private List<ParkingLotAssistant> assistants;

    ParkingLot(String name, int size) {
        this.name = name;
        this.lots = new ArrayList<>(size);
        this.assistants = new ArrayList<>();
        this.attendants = new ArrayList<>();
        this.MAX_LOT_SIZE = size;
    }

    void registerAttendant(ParkingLotAttendant attendant) {
        this.attendants.add(attendant);
    }

    void registerAssistant(ParkingLotAssistant assistant) {
        this.assistants.add(assistant);
    }

    String getName() {
        return name;
    }

    Integer getNumberOfCars() {
        return lots.size();
    }

    int park(Car car) throws ParkingLotFullException {
        if (!isAvailable()) {
            throw new ParkingLotFullException();
        }
        this.lots.add(car);
        notifyParking();
        return lots.indexOf(car);
    }

    private void notifyParking() {
        if (!isAvailable()) {
            for (ParkingLotAttendant attendant : this.attendants) {
                attendant.notifyParkingLotFull(this);
            }
        }
        for (ParkingLotAssistant assistant : this.assistants) {
            assistant.notifyParking(this);
        }
        notifyAttendantForLessThanOrEqualToTwenty();
    }

    boolean isAvailable() {
        return !(lots.size() == MAX_LOT_SIZE);
    }


    Car unpark(int carKey) throws CarNotFoundException {
        boolean isFull = !this.isAvailable();
        for (Car car : this.lots) {
            if (car.isSameKey(carKey)) {
                lots.remove(car);
                notifyUnParking(isFull);
                return car;
            }
        }
        throw new CarNotFoundException();
    }

    private void notifyAttendantForLessThanOrEqualToTwenty(){
        if((this.getNumberOfCars() / MAX_LOT_SIZE * 100) <= 20)
            for (ParkingLotAttendant attendant : this.attendants) {
                attendant.notifyLessThanTwentyPercent(this);
            }
    }

    private void notifyUnParking(boolean isFull) {
        if (isFull && this.isAvailable()) {
            for (ParkingLotAttendant attendant : this.attendants) {
                attendant.notifyParkingLotHasSpace(this);
            }
        }
        for (ParkingLotAssistant assistant : this.assistants) {
            assistant.notifyUnParking(this);
        }
        notifyAttendantForLessThanOrEqualToTwenty();
    }
}
