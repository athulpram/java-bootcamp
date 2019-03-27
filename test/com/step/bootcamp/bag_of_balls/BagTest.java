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
        bag.addValidation(new RedNotMoreThanDoubleOfGreen());
        bag.addValidation(new YellowLessThanFourtyPercent());
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

    @Test
    void shouldTestADeluxeBagForYellowNotMoreThanFourtyPercent() {
        Bag deluxeBag = new Bag();
        deluxeBag.addValidation(new MaximumOfTwentyBalls());
        deluxeBag.addValidation(new MaxThreeGreen());
        deluxeBag.addValidation(new RedNotMoreThanDoubleOfGreen());
        deluxeBag.addValidation(new YellowLessThanFourtyPercent());

        assertFalse(bag.addBall(Ball.YELLOW));
    }

    @Test
    void shouldReturnFalseForRedMoreThanGreen() {
        Bag deluxeBag = new Bag();
        deluxeBag.addValidation(new MaximumOfTwentyBalls());
        deluxeBag.addValidation(new MaxThreeGreen());
        deluxeBag.addValidation(new RedNotMoreThanDoubleOfGreen());
        deluxeBag.addValidation(new YellowLessThanFourtyPercent());

        assertFalse(bag.addBall(Ball.RED));
    }

    @Test
    void shouldTestTheMaximumCapacityOfDeluxeBag() {
        Bag deluxeBag = new Bag();
        deluxeBag.addValidation(new MaximumOfTwentyBalls());
        deluxeBag.addValidation(new MaxThreeGreen());
        deluxeBag.addValidation(new RedNotMoreThanDoubleOfGreen());
        deluxeBag.addValidation(new YellowLessThanFourtyPercent());
        for(int i=0;i<10;i++) {
            bag.addBall(Ball.BLACK);
        }
        assertFalse(bag.addBall(Ball.BLUE));
    }

    @Test
    void shouldReturnFalseForMoreThanOneBlack() {
        Bag deluxeBag = new Bag();
        deluxeBag.addValidation(new MaximumOfTwentyBalls());
        deluxeBag.addValidation(new MaxThreeGreen());
        deluxeBag.addValidation(new RedNotMoreThanDoubleOfGreen());
        deluxeBag.addValidation(new YellowLessThanFourtyPercent());
        deluxeBag.addValidation(new BlackNotMoreThanOne());
        bag.addBall(Ball.BLACK);
        bag.addBall(Ball.BLACK);
        assertTrue(bag.addBall(Ball.BLACK));
    }
}