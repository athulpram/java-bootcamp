package com.step.bootcamp.pizzacompany;

public enum Topping {
    VEGETABLE("Vegetable",Price.createPrice(20)),
    CHICKEN("Chicken",Price.createPrice(30)),
    MOZZARELLA("Mozzarella",Price.createPrice(10)),
    TOMATO_SAUCE("Tomato Sauce",Price.createPrice(5)),
    EXTRA_CHEESE("Extra Cheese",Price.createPrice(25)),
    JALAPENO("Jalapeno",Price.createPrice(40));

    private final Price cost;
    private final String name;

    Topping(String name, Price cost) {
        this.cost = cost;
        this.name = name;
    }

    public Price getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
