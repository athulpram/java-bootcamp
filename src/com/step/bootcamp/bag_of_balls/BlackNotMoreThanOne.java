package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;

public class BlackNotMoreThanOne implements Validator {

    @Override
    public boolean validate(HashMap<Ball, Integer> ballsCount, Ball ball) {
        int blackBallCount = 0;
        if (ballsCount.containsKey(Ball.BLACK))
            blackBallCount = ballsCount.get(Ball.BLACK);
        return ball != Ball.BLACK || blackBallCount < 1;
    }
}
