package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;
import java.util.Map;

public class YellowLessThanFourtyPercent implements Validator {
    @Override
    public boolean validate(HashMap<Ball, Integer> ballsCount, Ball ball) {
        int total = 0;
        for(Map.Entry<Ball, Integer> ballCount : ballsCount.entrySet()){
            total+=ballCount.getValue();
        }
        double yellowBallCount = 0;
        if (ballsCount.containsKey(Ball.YELLOW)) {
             yellowBallCount = (double)ballsCount.get(Ball.YELLOW);
        }
        boolean status = true;
        if(((yellowBallCount+1D)/(total+1D))*100D > 40D ){
            status = false;
        }
        return ball!=Ball.YELLOW || status;
    }
}
