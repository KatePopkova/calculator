package com.calculator.model;

public class OperationModel {
    private String operation;
    private float firstNumber;
    private float  secondNumber;

    public OperationModel() {
    }

    public OperationModel(String operation) {
        this.operation = operation;
    }

    public OperationModel(float firstNumber, float  secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public float getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(float firstNumber) {
        this.firstNumber = firstNumber;
    }

    public float getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(float secondNumber) {
        this.secondNumber = secondNumber;
    }
}