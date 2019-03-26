package com.step.bootcamp.bag_of_balls;

import java.util.HashMap;

public interface Validator {
    boolean validate(HashMap<Ball,Integer> ballsCount,Ball ball);
}
