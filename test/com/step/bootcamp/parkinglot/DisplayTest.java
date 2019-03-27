package com.step.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    @Test
    void shouldUpdateTheDisplayOfTheParkingLot() {
        Display plDisplay = Display.getInstance();
        plDisplay.updateDisplay("abc",0);
        String displayContent = plDisplay.toString();
        String expected = "Display{parkingLots={abc=0}}";
        assertEquals(expected,displayContent);
    }
}