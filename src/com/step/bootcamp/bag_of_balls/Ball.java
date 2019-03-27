package com.step.bootcamp.bag_of_balls;

enum Ball{
    RED(1),
    GREEN(1),
    YELLOW(1),
    BLUE(1),
    BLACK(2);

    private int size;

    Ball(int size) {
        this.size = size;
    }


    public Integer getSize() {
        return size;
    }
}