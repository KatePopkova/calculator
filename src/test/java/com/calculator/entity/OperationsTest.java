package com.calculator.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationsTest {
    final static Operations pojo = new Operations();
    final static String ID_FIELD_NAME = "id";
    final static String FIRST_NUMBER_FIELD_NAME = "firstNumber";
    final static String SECOND_NUMBER_FIELD_NAME = "secondNumber";
    final static String OPERATION_FIELD_NAME = "operation";
    final static String RESULT_FIELD_NAME = "result";
    final static int ID = 1;
    private final static float FIRST_NUMBER = 5.2f;
    private final static float SECOND_NUMBER = 2.0f;
    private final static float RESULT = 7.2f;
    private final static String OPERATION = "sum";
    final static int DELTA = 0;

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField(ID_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, ID);
        Assert.assertEquals("\"id\" field has not been retrieved properly",
                ID, pojo.getId(), DELTA);
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        pojo.setId(ID);
        final Field field = pojo.getClass().getDeclaredField(ID_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("\"id\" field value has not been matched",
                ID, field.get(pojo));
    }

    @Test
    void getFirstNumber() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField(FIRST_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, FIRST_NUMBER);
        Assert.assertEquals("\"firstNumber\" field has not been retrieved properly",
                FIRST_NUMBER, pojo.getFirstNumber(), DELTA);
    }

    @Test
    void setFirstNumber()  throws NoSuchFieldException, IllegalAccessException {
        pojo.setFirstNumber(FIRST_NUMBER);
        final Field field = pojo.getClass().getDeclaredField(FIRST_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("\"firstNumber\" field value has not been matched",
                FIRST_NUMBER, field.get(pojo));
    }

    @Test
    void getOperation() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField(OPERATION_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, OPERATION);
        Assert.assertEquals("\"operation\" field has not been retrieved properly",
                OPERATION, pojo.getOperation());
    }

    @Test
    void setOperation()  throws NoSuchFieldException, IllegalAccessException {
        pojo.setOperation(OPERATION);
        final Field field = pojo.getClass().getDeclaredField(OPERATION_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("\"operation\" field value has not been matched",
                OPERATION, field.get(pojo));
    }

    @Test
    void getSecondNumber()  throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField(SECOND_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, SECOND_NUMBER);
        Assert.assertEquals("\"secondNumber\" field has not been retrieved properly",
                SECOND_NUMBER, pojo.getSecondNumber(), DELTA);
    }

    @Test
    void setSecondNumber() throws NoSuchFieldException, IllegalAccessException {
        pojo.setSecondNumber(SECOND_NUMBER);
        final Field field = pojo.getClass().getDeclaredField(SECOND_NUMBER_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("\"secondNumber\" field value has not been matched",
                SECOND_NUMBER, field.get(pojo));
    }

    @Test
    void getResult() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField(RESULT_FIELD_NAME);
        field.setAccessible(true);
        field.set(pojo, RESULT);
        Assert.assertEquals("\"result\" field has not been retrieved properly",
                RESULT, pojo.getResult(), DELTA);
    }

    @Test
    void setResult() throws NoSuchFieldException, IllegalAccessException {
        pojo.setResult(RESULT);
        final Field field = pojo.getClass().getDeclaredField(RESULT_FIELD_NAME);
        field.setAccessible(true);
        Assert.assertEquals("\"result\" field value has not been matched",
                RESULT, field.get(pojo));
    }
}