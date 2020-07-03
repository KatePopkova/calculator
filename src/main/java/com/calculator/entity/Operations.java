package com.calculator.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_number", nullable = false)
    private float firstNumber;

    @Column(name = "operation", nullable = false)
    private String operation;

    @Column(name = "second_number", nullable = false)
    private float secondNumber;

    @Column(name = "result", nullable = false)
    private float result;

    public Operations() {
    }

    public Operations(float firstNumber, String operation, float  secondNumber, float result) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(float firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(float secondNumber) {
        this.secondNumber = secondNumber;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}