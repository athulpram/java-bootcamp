package com.step.bootcamp.bag_of_balls;

public class YellowLessThanFourtyPercent implements Validator {
    @Override
    public boolean validate(CountableBalls balls, Ball ball) {
        int total = balls.totalNumberOfBalls();
        double yellowBallCount = balls.getCountOf(Ball.YELLOW);
        boolean status = true;
        if(((yellowBallCount+1D)/(total+1D))*100D > 40D ){
            status = false;
        }
        return ball!=Ball.YELLOW || status;
    }
}
