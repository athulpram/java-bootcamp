package com.step.bootcamp.bag_of_balls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bag {
    private Map<Ball, Integer> ballCount;
    private List<Validator> validations;

    Bag() {
        this.validations = new ArrayList<>();
        this.ballCount = new HashMap<>();
    }
    void addValidation(Validator validation){
        this.validations.add(validation);
    }

    boolean addBall(Ball ball) {
        boolean isValid = true;
        for (Validator validation : validations) {
            isValid = isValid && validation.validate((HashMap<Ball, Integer>) ballCount, ball);
        }
        if(isValid){
            if(ballCount.containsKey(ball)) {
                this.ballCount.put(ball, ballCount.get(ball) + 1);
                return true;
            }
            ballCount.put(ball,1);
            return true;
        }
        return false;
    }
}
