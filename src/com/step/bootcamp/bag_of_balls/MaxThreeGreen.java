package com.step.bootcamp.bag_of_balls;

public class MaxThreeGreen implements Validator {

    @Override
    public boolean validate(CountableBalls balls, Ball ball) {
        int greenBallCount = balls.getCountOf(Ball.GREEN);
        return ball != Ball.GREEN || greenBallCount < 3;
    }
}
