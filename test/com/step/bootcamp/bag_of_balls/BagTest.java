package com.step.bootcamp.bag_of_balls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    private static Bag bag;

    @BeforeEach
    void setUp() {
        bag = new Bag();
        bag.addValidation(new MaxBalls());
        bag.addValidation(new MaxThreeGreen());
    }

    @Test
    void shouldReturnTrueForASuccessfullAdditionOfBall() {
        assertTrue(bag.addBall(Ball.BLUE));
    }


    @Test
    void shouldReturnFalseForThirteenthBall() {
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        bag.addBall(Ball.BLUE);
        assertFalse(bag.addBall(Ball.BLUE));

    }

    @Test
    void shouldReturnFalseForFourthGreenBall() {
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        assertFalse(bag.addBall(Ball.GREEN));
    }
}