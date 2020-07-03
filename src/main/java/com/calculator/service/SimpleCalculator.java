package com.calculator.service;

import com.calculator.model.OperationModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SimpleCalculator {
    private static final int DIGIT_COUNT = 3;

    public BigDecimal getSum(OperationModel model){
        return model.getFirstNumber().add(model.getSecondNumber());
    }

    public BigDecimal getSubtraction(OperationModel model){
        return model.getFirstNumber().subtract(model.getSecondNumber());
    }

    public BigDecimal getMultiplication(OperationModel model){
        return model.getFirstNumber().multiply(model.getSecondNumber())
                .setScale(DIGIT_COUNT, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getQuotient(OperationModel model){
        return model.getFirstNumber().divide(model.getSecondNumber(),
                DIGIT_COUNT, RoundingMode.HALF_EVEN);
    }
}