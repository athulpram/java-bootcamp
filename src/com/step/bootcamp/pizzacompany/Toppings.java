package com.step.bootcamp.pizzacompany;

import java.util.ArrayList;
import java.util.List;

class Toppings {
    private List<Topping> toppings= new ArrayList<>();

    Toppings() {
    }

    void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    Price calculatePrice(){
        Price toppingsPrice = Price.createPrice(0);
        for (Topping topping : toppings) {
            toppingsPrice = toppingsPrice.add(topping.getCost());
        }
        return toppingsPrice;
    }

    String getDescription(){
        return "";
    }
}
