package com.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void shouldReturnTheAreaOfRectangle() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(4),new Dimension(5));
        double expectedOutput = 20.0D;
        assertEquals(expectedOutput, rectangle.calculateArea());
    }

    @Test
    void shouldReturnZeroForDimensionZero() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(0), new Dimension(0));
        double expected = 0D;
        ArrayList<String> strings = new ArrayList<>();
        assertEquals(expected,rectangle.calculateArea());
    }

    @Test
    void shouldReturnThePerimeterOfRectangle() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(4),new Dimension(5));
        double expectedOutput = 18.0D;
        assertEquals(expectedOutput, rectangle.calculatePerimeter());
    }
}