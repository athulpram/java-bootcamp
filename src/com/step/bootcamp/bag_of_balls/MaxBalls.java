package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;
import java.util.Map;

public class MaxBalls implements Validator{

    @Override
    public boolean validate(HashMap<Ball, Integer> ballsCount, Ball ball) {
        int total = 0;
        for(Map.Entry<Ball, Integer> ballCount : ballsCount.entrySet()){
            total+=ballCount.getValue();
        }
        return total<12;
    }
}
