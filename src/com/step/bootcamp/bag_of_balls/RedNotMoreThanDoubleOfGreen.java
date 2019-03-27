package com.step.bootcamp.bag_of_balls;

public class RedNotMoreThanDoubleOfGreen implements Validator{

    @Override
    public boolean validate(CountableBalls balls, Ball ball) {
        int numberOfGreenBalls = balls.getCountOf(Ball.GREEN);
        int numberOfRedBalls = balls.getCountOf(Ball.RED);
        boolean status = true;
        if(numberOfGreenBalls == numberOfRedBalls){
            status = false;
        }
        return ball != Ball.RED || status;
    }
}
