package com.calculator.controller;

import com.calculator.entity.Operations;
import com.calculator.model.OperationModel;
import com.calculator.repo.OperationsRepo;
import com.calculator.service.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    private static final String CALCULATOR = "calculator";
    private static final String OPERATION_MODEL = "operationModel";
    private static final String RESULT = "result";
    private static final String GET_SUM_PARAM = "getSum";
    private static final String GET_SUBTRACTION_PARAM = "getSubtraction";
    private static final String GET_MULTIPLICATION_PARAM = "getMultiplication";
    private static final String GET_QUOTIENT_PARAM = "getQuotient";
    private static final String SLASH = "/";
    private static final String REQUESTS = "requests";
    private static final String SUM = "sum";
    private static final String SUBTRACTION = "subtraction";
    private static final String MULTIPLICATION = "multiplication";
    private static final String DIVISION = "division";

    private OperationModel operationModel = new OperationModel();

    @Autowired
    private SimpleCalculator simpleCalculator;

    @Autowired
    private OperationsRepo operationsRepo;

    @GetMapping
    public String getCalculatorPage(Model model) {
        model.addAttribute(OPERATION_MODEL, operationModel);
        return CALCULATOR;
    }

    @PostMapping(params = GET_SUM_PARAM)
    public String getSum(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        BigDecimal result = simpleCalculator.getSum(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(), SUM, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_SUBTRACTION_PARAM)
    public String getSubtraction(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        BigDecimal result = simpleCalculator.getSubtraction(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(), SUBTRACTION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_MULTIPLICATION_PARAM)
    public String getMultiplication(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        BigDecimal result = simpleCalculator.getMultiplication(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(), MULTIPLICATION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_QUOTIENT_PARAM)
    public String getQuotient(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        BigDecimal result = simpleCalculator.getQuotient(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(), DIVISION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    private void addRequestToDataBase(BigDecimal firstNumber, String operation, BigDecimal secondNumber, BigDecimal result) {
        Operations operationRequest = new Operations(firstNumber, operation, secondNumber, result);
        operationsRepo.save(operationRequest);
    }

    @GetMapping(value = SLASH + REQUESTS)
    public String getDbRequestCount(Model model) {
        Iterable<Operations> operationRequests = operationsRepo.findAll();
        model.addAttribute(RESULT, operationRequests.spliterator().estimateSize());
        return REQUESTS;
    }
}