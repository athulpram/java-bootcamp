package com.step.bootcamp.pizzacompany;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void shouldReturnTotalPrice() {
        Pizza pizza = new Pizza();
        pizza.addTopping(Topping.MOZZARELLA);
        pizza.addTopping(Topping.CHICKEN);

        Price expectedTotalPrice = Price.createPrice(90);
        Price actualTotalPrice = pizza.getTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}