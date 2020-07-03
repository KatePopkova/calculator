package com.calculator.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_number", nullable = false)
    private BigDecimal firstNumber;

    @Column(name = "operation", nullable = false)
    private String operation;

    @Column(name = "second_number", nullable = false)
    private BigDecimal secondNumber;

    @Column(name = "result", nullable = false)
    private BigDecimal result;

    public Operations() {
    }

    public Operations(BigDecimal firstNumber, String operation, BigDecimal  secondNumber, BigDecimal result) {
        this.firstNumber = firstNumber;
        this.operation = operation;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(BigDecimal firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(BigDecimal secondNumber) {
        this.secondNumber = secondNumber;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}