package com.step.bootcamp.pizzacompany;

class Pizza {
    private Price basePrice;
    private Toppings toppings = new Toppings();


    Pizza() {
        this.basePrice = Price.createPrice(50);
    }

    void addTopping(Topping topping){
        toppings.addTopping(topping);
    }

    Price getTotalPrice(){
        return this.basePrice.add(toppings.calculatePrice());
    }

    String getDescription(){

    }
}
