package com.step.bootcamp.bag_of_balls;


public class MaxBalls implements Validator{

    @Override
    public boolean validate(CountableBalls balls, Ball ball) {
        int total = balls.totalNumberOfBalls();
        return total<12;
    }
}
