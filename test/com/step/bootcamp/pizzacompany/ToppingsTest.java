package com.step.bootcamp.pizzacompany;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingsTest {

    @Test
    void shouldReturnTotalPriceOfToppings() {
        Toppings toppings = new Toppings();
        toppings.addTopping(Topping.EXTRA_CHEESE);
        toppings.addTopping(Topping.MOZZARELLA);

        Price expectedPrice = Price.createPrice(35);
        Price actualPrice = toppings.calculatePrice();

        assertEquals(expectedPrice, actualPrice);
    }
}