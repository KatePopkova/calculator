package com.calculator.service;

import com.calculator.model.OperationModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimpleCalculatorTest {
    private static final OperationModel OPERATION_MODEL = new OperationModel();
    private final static BigDecimal FIRST_NUMBER = new BigDecimal(5.2);
    private final static BigDecimal SECOND_NUMBER = new BigDecimal(2.0);
    private final static BigDecimal SUM_RESULT = new BigDecimal(7.2);
    private final static BigDecimal SUBTRACTION_RESULT = new BigDecimal(3.2);
    private final static BigDecimal MULTIPLICATION_RESULT = new BigDecimal(10.4);
    private final static BigDecimal DIVISION_RESULT = new BigDecimal(2.6);
    private final static String FIRST_NUMBER_FIELD_NAME = "firstNumber";
    private final static String SECOND_NUMBER_FIELD_NAME = "secondNumber";
    private final static int DIGIT_COUNT = 3;

    @Test
    void getSum() throws NoSuchFieldException, IllegalAccessException  {
        setValues();
        Assert.assertEquals("Sum method does not work properly", SUM_RESULT,
                OPERATION_MODEL.getFirstNumber().add(OPERATION_MODEL.getSecondNumber()));
    }

    @Test
    void getSubtraction() throws NoSuchFieldException, IllegalAccessException {
        setValues();
        Assert.assertEquals("Subtraction method does not work properly", SUBTRACTION_RESULT,
                OPERATION_MODEL.getFirstNumber().subtract(OPERATION_MODEL.getSecondNumber()));
    }

    @Test
    void getMultiplication() throws NoSuchFieldException, IllegalAccessException  {
        setValues();
        Assert.assertEquals("Multiplication method does not work properly",
                MULTIPLICATION_RESULT.setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN),
                OPERATION_MODEL.getFirstNumber().multiply(OPERATION_MODEL.getSecondNumber())
                        .setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN));
    }

    @Test
    void getQuotient() throws NoSuchFieldException, IllegalAccessException  {
        setValues();
        Assert.assertEquals("Divide method does not work properly",
                DIVISION_RESULT.setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN),
                OPERATION_MODEL.getFirstNumber().divide(OPERATION_MODEL.getSecondNumber(),
                        DIGIT_COUNT, RoundingMode.HALF_EVEN));
    }

    private void setValues() throws NoSuchFieldException, IllegalAccessException {
        final Field firstNumberField = OPERATION_MODEL.getClass().getDeclaredField(FIRST_NUMBER_FIELD_NAME);
        firstNumberField.setAccessible(true);
        firstNumberField.set(OPERATION_MODEL, FIRST_NUMBER);

        final Field secondNumberField = OPERATION_MODEL.getClass().getDeclaredField(SECOND_NUMBER_FIELD_NAME);
        secondNumberField.setAccessible(true);
        secondNumberField.set(OPERATION_MODEL, SECOND_NUMBER);
    }
}