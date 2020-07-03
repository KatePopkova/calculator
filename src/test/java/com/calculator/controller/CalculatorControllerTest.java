package com.calculator.controller;

import com.calculator.model.OperationModel;
import com.calculator.service.SimpleCalculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorControllerTest {
    private final static BigDecimal FIRST_NUMBER = new BigDecimal(5.2);
    private final static BigDecimal SECOND_NUMBER = new BigDecimal(2.0);
    private final static BigDecimal SUM_RESULT = new BigDecimal(7.2);
    private final static BigDecimal SUBTRACTION_RESULT = new BigDecimal(3.2);
    private final static BigDecimal MULTIPLICATION_RESULT = new BigDecimal(10.4);
    private final static BigDecimal DIVISION_RESULT = new BigDecimal(2.6);
    private final static SimpleCalculator SIMPLE_CALCULATOR = new SimpleCalculator();
    private final static OperationModel OPERATION_MODEL = new OperationModel(FIRST_NUMBER, SECOND_NUMBER);
    private final static int DIGIT_COUNT = 3;

    @Test
    void getSum() {
        checkFieldSetting();
        Assert.assertEquals("Sum method does not work properly", SUM_RESULT,
                SIMPLE_CALCULATOR.getSum(OPERATION_MODEL));
    }

    @Test
    void getSubtraction() {
        checkFieldSetting();
        Assert.assertEquals("Subtraction method does not work properly", SUBTRACTION_RESULT,
                SIMPLE_CALCULATOR.getSubtraction(OPERATION_MODEL));
    }

    @Test
    void getMultiplication() {
        checkFieldSetting();
        Assert.assertEquals("Multiplication method does not work properly",
                MULTIPLICATION_RESULT.setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN),
                SIMPLE_CALCULATOR.getMultiplication(OPERATION_MODEL));
    }

    @Test
    void getQuotient() {
        checkFieldSetting();
        Assert.assertEquals("Division method does not work properly",
                DIVISION_RESULT.setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN),
                SIMPLE_CALCULATOR.getQuotient(OPERATION_MODEL));
    }

    void checkFieldSetting() {
        Assert.assertEquals("\"firstNumber\" field has not set properly",
                FIRST_NUMBER, OPERATION_MODEL.getFirstNumber());
        Assert.assertEquals("\"secondNumber\" field has not set properly",
                SECOND_NUMBER, OPERATION_MODEL.getSecondNumber());
    }
}