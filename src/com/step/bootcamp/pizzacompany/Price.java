package com.step.bootcamp.pizzacompany;

class Price {
    private double amount;

    private Price(double amount){
        this.amount = amount;
    }

    static Price createPrice(double amount) {
        validate(amount);
        return new Price(amount);
    }

    private static void validate(double amount) throws InvalidAmountException {
        if(amount < 0) throw new InvalidAmountException();
    }

    @Override
    public boolean equals(Object anotherPrice) {
        if (this == anotherPrice) return true;
        if (anotherPrice == null || getClass() != anotherPrice.getClass()) return false;
        Price price = (Price) anotherPrice;
        return Double.compare(price.amount, amount) == 0;
    }

    Price add(Price anotherPrice){
        return new Price(this.amount + anotherPrice.amount);
    }
}
