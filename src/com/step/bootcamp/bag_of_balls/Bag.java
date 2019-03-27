package com.step.bootcamp.bag_of_balls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bag {
    private Balls ballCount;
    private List<Validator> validations;

    Bag() {
        this.validations = new ArrayList<>();
        this.ballCount = new Balls();
    }
    void addValidation(Validator validation){
        this.validations.add(validation);
    }

    boolean addBall(Ball ball) {
        boolean isValid = true;
        for (Validator validation : validations) {
            isValid = isValid && validation.validate(ballCount, ball);
        }
        if(isValid){
            ballCount.addBall(ball);
        }
        return false;
    }
}
