package com.step.bootcamp.shapes;

public final class Dimension {
    private final double value;

    public Dimension(double value) throws InvalidDimensionException {
        this.validateValue(value);
        this.value = value;
    }

    private void validateValue(double value) throws InvalidDimensionException {
        if (this.value < 0) {
            throw new InvalidDimensionException("Invalid dimension Exception");
        }
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
