package com.calculator.service;

import com.calculator.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {

    public float getSum(OperationModel model){
        return model.getFirstNumber() + model.getSecondNumber();
    }

    public float getSubtraction(OperationModel model){
        return model.getFirstNumber() - model.getSecondNumber();
    }

    public float getMultiplication(OperationModel model){
        return model.getFirstNumber() * model.getSecondNumber();
    }

    public float getQuotient(OperationModel model){
        return model.getFirstNumber() / model.getSecondNumber();
    }
}