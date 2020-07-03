package com.calculator.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationsTest {
    private final static Operations POJO = new Operations();
    private final static String ID_FIELD_NAME = "id";
    private final static String FIRST_NUMBER_FIELD_NAME = "firstNumber";
    private final static String SECOND_NUMBER_FIELD_NAME = "secondNumber";
    private final static String OPERATION_FIELD_NAME = "operation";
    private final static String RESULT_FIELD_NAME = "result";
    private final static Integer ID = 1;
    private final static BigDecimal FIRST_NUMBER = new BigDecimal(5.2);
    private final static BigDecimal SECOND_NUMBER = new BigDecimal(2.0);
    private final static BigDecimal RESULT = new BigDecimal(7.2f);
    private final static String OPERATION = "sum";

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(ID_FIELD_NAME, ID);
        Assert.assertEquals(ID_FIELD_NAME + " field has not been retrieved properly",
                Optional.of(ID), Optional.of(POJO.getId()));
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        POJO.setId(ID);
        Field field = setAccessibleFieldForSetters(ID_FIELD_NAME);
        Assert.assertEquals(ID_FIELD_NAME + " field value has not been matched",
                ID, field.get(POJO));
    }

    @Test
    void getFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(FIRST_NUMBER_FIELD_NAME, FIRST_NUMBER);
        Assert.assertEquals(FIRST_NUMBER_FIELD_NAME + " field has not been retrieved properly",
                FIRST_NUMBER, POJO.getFirstNumber());
    }

    @Test
    void setFirstNumber()  throws NoSuchFieldException, IllegalAccessException {
        POJO.setFirstNumber(FIRST_NUMBER);
        Field field = setAccessibleFieldForSetters(FIRST_NUMBER_FIELD_NAME);
        Assert.assertEquals(FIRST_NUMBER_FIELD_NAME + " field value has not been matched",
                FIRST_NUMBER, field.get(POJO));
    }

    @Test
    void getOperation() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(OPERATION_FIELD_NAME, OPERATION);
        Assert.assertEquals(OPERATION + " field has not been retrieved properly",
                OPERATION, POJO.getOperation());
    }

    @Test
    void setOperation()  throws NoSuchFieldException, IllegalAccessException {
        POJO.setOperation(OPERATION);
        Field field = setAccessibleFieldForSetters(OPERATION_FIELD_NAME);
        Assert.assertEquals(OPERATION + " field value has not been matched",
                OPERATION, field.get(POJO));
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
        Field field = setAccessibleFieldForSetters(SECOND_NUMBER_FIELD_NAME);
        Assert.assertEquals(SECOND_NUMBER_FIELD_NAME + " field value has not been matched",
                SECOND_NUMBER, field.get(POJO));
    }

    @Test
    void getResult() throws NoSuchFieldException, IllegalAccessException {
        setFieldForGetter(RESULT_FIELD_NAME, RESULT);
        Assert.assertEquals(RESULT + " field has not been retrieved properly",
                RESULT, POJO.getResult());
    }

    @Test
    void setResult() throws NoSuchFieldException, IllegalAccessException {
        POJO.setResult(RESULT);
        Field field = setAccessibleFieldForSetters(RESULT_FIELD_NAME);
        Assert.assertEquals(RESULT  + " field value has not been matched",
                RESULT, field.get(POJO));
    }

    private void setFieldForGetter(String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
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