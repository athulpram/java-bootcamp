package com.step.bootcamp.pizzacompany;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void shouldInitializeAValidAmount() {
        assertDoesNotThrow(()->Price.createPrice(10));
    }

    @Test
    void shouldThrowExceptionForInvalidAmount() {
        assertThrows(InvalidAmountException.class,()->Price.createPrice(-1));
    }
}