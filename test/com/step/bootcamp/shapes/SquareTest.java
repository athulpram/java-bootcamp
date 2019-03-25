package com.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void shouldReturnAreaOfSquare() throws InvalidDimensionException {
        Square square = new Square(new Dimension(4));
        assertEquals(16, square.calculateArea());
    }

    @Test
    void shouldReturnPerimeterOfSquare() throws InvalidDimensionException {
        Square square = new Square(new Dimension(5.711));
        assertEquals(Double.toString(22.84), String.format("%.2f", square.calculatePerimeter()));
    }
}