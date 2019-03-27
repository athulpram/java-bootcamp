package com.step.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

class Display {
    private Map<String,Integer> parkingLots;
    private static Display instance = new Display();

    static Display getInstance(){
        return instance;
    }

    private Display() {
        this.parkingLots = new HashMap<>();
    }

    void updateDisplay(String name,Integer numberOfCars){
        this.parkingLots.put(name,numberOfCars);
    }

    @Override
    public String toString() {
        return "Display{" +
                "parkingLots=" + parkingLots +
                '}';
    }
}
