package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;
import java.util.Map;

public class Balls implements CountableBalls {
    private Map<Ball, Integer> ballsCount;

    Balls() {
        ballsCount = new HashMap<>();
    }

    @Override
    public Integer getCountOf(Ball ball) {
        int ballCount = 0;
        if (ballsCount.containsKey(ball))
            ballCount = ballsCount.get(ball);
        return ballCount;
    }

    @Override
    public Integer totalNumberOfBalls() {
        int total = 0;
        for(Map.Entry<Ball, Integer> ballCount : ballsCount.entrySet()){
            total+=ballCount.getValue();
        }
        return total;
    }

    void addBall(Ball ball){
        if(ballsCount.containsKey(ball)) {
            this.ballsCount.put(ball, ballsCount.get(ball) + ball.getSize());
        }
        ballsCount.put(ball,1);
    }
}
