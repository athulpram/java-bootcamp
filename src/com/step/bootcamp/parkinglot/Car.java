package com.step.bootcamp.parkinglot;

class Car {
    private final Integer key;

    Car(int key) {
        this.key = key;
    }

    boolean isSameKey(int carKey) {
        return this.key.equals(carKey);
    }
}
