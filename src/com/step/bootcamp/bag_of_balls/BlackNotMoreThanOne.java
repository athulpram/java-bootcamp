package com.step.bootcamp.bag_of_balls;

public class BlackNotMoreThanOne implements Validator {

    @Override
    public boolean validate(CountableBalls balls, Ball ball) {
        int blackBallCount = balls.getCountOf(Ball.BLACK);
        return ball != Ball.BLACK || blackBallCount < 1;
    }
}
