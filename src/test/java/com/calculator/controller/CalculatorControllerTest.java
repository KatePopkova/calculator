package com.calculator.controller;

import com.calculator.model.OperationModel;
import com.calculator.service.SimpleCalculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorControllerTest {
    private final static float FIRST_NUMBER = 5.2f;
    private final static float SECOND_NUMBER = 2.0f;
    private final static float DELTA = 0.2f;
    private final static float ZERO_DELTA = 0.0f;
    private final static float SUM_RESULT = 7.2f;
    private final static float SUBTRACTION_RESULT = 3.2f;
    private final static float MULTIPLICATION_RESULT = 10.4f;
    private final static float DIVISION_RESULT = 2.6f;
    private final static SimpleCalculator SIMPLE_CALCULATOR = new SimpleCalculator();
    private final static OperationModel OPERATION_MODEL = new OperationModel(FIRST_NUMBER, SECOND_NUMBER);

    @Test
    void getSum() {
        checkFieldSetting();
        Assert.assertEquals("Sum method does not work properly", SUM_RESULT,
                SIMPLE_CALCULATOR.getSum(OPERATION_MODEL), DELTA);
    }

    @Test
    void getSubtraction() {
        checkFieldSetting();
        Assert.assertEquals("Subtraction method does not work properly", SUBTRACTION_RESULT,
                SIMPLE_CALCULATOR.getSubtraction(OPERATION_MODEL), DELTA);
    }

    @Test
    void getMultiplication() {
        checkFieldSetting();
        Assert.assertEquals("Multiplication method does not work properly", MULTIPLICATION_RESULT,
                SIMPLE_CALCULATOR.getMultiplication(OPERATION_MODEL), DELTA);
    }

    @Test
    void getQuotient() {
        checkFieldSetting();
        Assert.assertEquals("Division method does not work properly", DIVISION_RESULT,
                SIMPLE_CALCULATOR.getQuotient(OPERATION_MODEL), DELTA);
    }

    void checkFieldSetting() {
        Assert.assertEquals("\"firstNumber\" field has not set properly",
                FIRST_NUMBER, OPERATION_MODEL.getFirstNumber(), ZERO_DELTA);
        Assert.assertEquals("\"secondNumber\" field has not set properly",
                SECOND_NUMBER, OPERATION_MODEL.getSecondNumber(), ZERO_DELTA);
    }
}