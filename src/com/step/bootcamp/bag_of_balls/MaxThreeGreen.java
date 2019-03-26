package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;

public class MaxThreeGreen implements Validator {

    @Override
    public boolean validate(HashMap<Ball, Integer> ballsCount, Ball ball) {
        int greenBallCount = 0;
        if (ballsCount.containsKey(Ball.GREEN))
            greenBallCount = ballsCount.get(Ball.GREEN);
        return ball != Ball.GREEN || greenBallCount < 3;
    }
}
