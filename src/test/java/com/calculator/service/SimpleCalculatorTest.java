package com.calculator.service;

import com.calculator.model.OperationModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimpleCalculatorTest {
    private static final OperationModel operationModel = new OperationModel();
    private final static float FIRST_NUMBER = 5.2f;
    private final static float SECOND_NUMBER = 2.0f;
    private final static float SUM_RESULT = 7.2f;
    private final static float SUBTRACTION_RESULT = 3.2f;
    private final static float MULTIPLICATION_RESULT = 10.4f;
    private final static float DIVISION_RESULT = 2.6f;
    private final static float DELTA = 0.2f;

    @Test
    void getSum() {
        operationModel.setFirstNumber(FIRST_NUMBER);
        operationModel.setSecondNumber(SECOND_NUMBER);
        Assert.assertEquals("Sum method does not work properly", SUM_RESULT,
                operationModel.getFirstNumber() + operationModel.getSecondNumber(), DELTA);
    }

    @Test
    void getSubtraction() {
        operationModel.setFirstNumber(FIRST_NUMBER);
        operationModel.setSecondNumber(SECOND_NUMBER);
        Assert.assertEquals("Subtraction method does not work properly", SUBTRACTION_RESULT,
                operationModel.getFirstNumber() - operationModel.getSecondNumber(), DELTA);
    }

    @Test
    void getMultiplication() {
        operationModel.setFirstNumber(FIRST_NUMBER);
        operationModel.setSecondNumber(SECOND_NUMBER);
        Assert.assertEquals("Multiplication method does not work properly", MULTIPLICATION_RESULT,
                operationModel.getFirstNumber() * operationModel.getSecondNumber(), DELTA);
    }

    @Test
    void getQuotient() {
        operationModel.setFirstNumber(FIRST_NUMBER);
        operationModel.setSecondNumber(SECOND_NUMBER);
        Assert.assertEquals("Divide method does not work properly", DIVISION_RESULT,
                operationModel.getFirstNumber() / operationModel.getSecondNumber(), DELTA);
    }
}