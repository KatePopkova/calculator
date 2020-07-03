package com.calculator.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationModelTest {
    private final static float FIRST_NUMBER = 5.2f;
    private final static float SECOND_NUMBER = 2.4f;
    private final static float DELTA = 0.0f;
    private final static String FIRST_NUMBER_FIELD_NAME = "firstNumber";
    private final static String SECOND_NUMBER_FIELD_NAME = "secondNumber";

    @Test
    void getFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        final OperationModel pojo = new OperationModel();
        final Field field = pojo.getClass().getDeclaredField(FIRST_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, FIRST_NUMBER);
        Assert.assertEquals("Field has not been retrieved properly", FIRST_NUMBER, pojo.getFirstNumber(), DELTA);
    }

    @Test
    void setFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        final OperationModel pojo = new OperationModel();
        pojo.setFirstNumber(FIRST_NUMBER);
        final Field field = pojo.getClass().getDeclaredField(FIRST_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("Field value has not been matched", FIRST_NUMBER, field.get(pojo));
    }

    @Test
    void getSecondNumber() throws NoSuchFieldException, IllegalAccessException {
        final OperationModel pojo = new OperationModel();
        final Field field = pojo.getClass().getDeclaredField(SECOND_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, SECOND_NUMBER);
        Assert.assertEquals("Field has not been retrieved properly", SECOND_NUMBER, pojo.getSecondNumber(), DELTA);
    }

    @Test
    void setSecondNumber() throws NoSuchFieldException, IllegalAccessException {
        final OperationModel pojo = new OperationModel();
        pojo.setSecondNumber(SECOND_NUMBER);
        final Field field = pojo.getClass().getDeclaredField(SECOND_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("Field value has not been matched", SECOND_NUMBER, field.get(pojo));
    }
}