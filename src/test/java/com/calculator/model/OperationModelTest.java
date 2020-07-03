package com.calculator.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationModelTest {
    private final static OperationModel POJO = new OperationModel();
    private final static BigDecimal FIRST_NUMBER = new BigDecimal(5.2);
    private final static BigDecimal SECOND_NUMBER = new BigDecimal(2.4);
    private final static String FIRST_NUMBER_FIELD_NAME = "firstNumber";
    private final static String SECOND_NUMBER_FIELD_NAME = "secondNumber";

    @Test
    void getFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(FIRST_NUMBER_FIELD_NAME, FIRST_NUMBER);
        Assert.assertEquals(FIRST_NUMBER_FIELD_NAME + " field has not been retrieved properly",
                FIRST_NUMBER, POJO.getFirstNumber());
    }

    @Test
    void setFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        POJO.setFirstNumber(FIRST_NUMBER);
        final Field field = setAccessibleFieldForSetters(FIRST_NUMBER_FIELD_NAME);
        Assert.assertEquals(FIRST_NUMBER_FIELD_NAME + " field value has not been matched",
                FIRST_NUMBER, field.get(POJO));
    }

    @Test
    void getSecondNumber() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(SECOND_NUMBER_FIELD_NAME, SECOND_NUMBER);
        Assert.assertEquals(SECOND_NUMBER_FIELD_NAME + " field has not been retrieved properly",
                SECOND_NUMBER, POJO.getSecondNumber());
    }

    @Test
    void setSecondNumber() throws NoSuchFieldException, IllegalAccessException {
        POJO.setSecondNumber(SECOND_NUMBER);
        final Field field = setAccessibleFieldForSetters(SECOND_NUMBER_FIELD_NAME);
        Assert.assertEquals(SECOND_NUMBER_FIELD_NAME + " field value has not been matched",
                SECOND_NUMBER, field.get(POJO));
    }

    private void setFieldForGetter(String fieldName, BigDecimal value) throws NoSuchFieldException, IllegalAccessException {
        final Field field = POJO.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(POJO, value);
    }

    private Field setAccessibleFieldForSetters(String fieldName) throws NoSuchFieldException {
        final Field field = POJO.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }
}