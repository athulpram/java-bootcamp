package com.step.bootcamp.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DimensionTest {
    @Test
    void shouldThrowExceptionIfTheValueIsLessThanZero() {
        assertThrows(InvalidDimensionException.class, ()-> {
            new Dimension(-1);
        });
    }

    @Test
    void shouldReturnValueForDimension() throws Exception {
        Dimension dimension = new Dimension(1);
        double expected = 1D;
        assertEquals(expected,dimension.getValue());
    }
}