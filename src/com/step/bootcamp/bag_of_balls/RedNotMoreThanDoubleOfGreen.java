package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;

public class RedNotMoreThanDoubleOfGreen implements Validator{

    @Override
    public boolean validate(HashMap<Ball, Integer> ballsCount, Ball ball) {
        int numberOfGreenBalls = 0;
        int numberOfRedBalls = 0;
        if (ballsCount.containsKey(Ball.GREEN))
        numberOfGreenBalls = ballsCount.get(Ball.GREEN);
        if (ballsCount.containsKey(Ball.RED))
        numberOfRedBalls = ballsCount.get(Ball.RED);
        boolean status = true;
        if(numberOfGreenBalls == numberOfRedBalls){
            status = false;
        }
        return ball != Ball.RED || status;
    }
}
