package com.step.bootcamp.shapes;

public class Square implements Shape {
    private Dimension side;

    public Square(Dimension side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return this.side.getValue() * this.side.getValue();
    }

    @Override
    public double calculatePerimeter() {
        return this.side.getValue() * 4;
    }
}
