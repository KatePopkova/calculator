package com.calculator.controllers;

import com.calculator.entity.Operations;
import com.calculator.model.OperationModel;
import com.calculator.repo.DataBaseRequestRepo;
import com.calculator.service.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private static final String GET_DB_REQUESTS = "getCountDbRequests";
    private static final String SUM = "sum";
    private static final String SUBTRACTION = "subtraction";
    private static final String MULTIPLICATION = "multiplication";
    private static final String DIVISION = "division";

    private OperationModel operationModel = new OperationModel();

    @Autowired
    private SimpleCalculator simpleCalculator;

    @Autowired
    private DataBaseRequestRepo dataBaseRequestRepo;

    @GetMapping
    public String getCalculatorPage(Model model){
        model.addAttribute(OPERATION_MODEL, operationModel);
        return CALCULATOR;
    }

    @PostMapping(params = GET_SUM_PARAM)
    public String getSum(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        float result = simpleCalculator.getSum(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(),SUM, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_SUBTRACTION_PARAM)
    public String getSubtraction(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        float result = simpleCalculator.getSubtraction(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(), SUBTRACTION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_MULTIPLICATION_PARAM)
    public String getMultiplication(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        float result = simpleCalculator.getMultiplication(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(),MULTIPLICATION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    @PostMapping(params = GET_QUOTIENT_PARAM)
    public String getQuotient(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        float result = simpleCalculator.getQuotient(operationModel);
        addRequestToDataBase(operationModel.getFirstNumber(),DIVISION, operationModel.getSecondNumber(), result);
        model.addAttribute(RESULT, result);
        return CALCULATOR;
    }

    private void addRequestToDataBase(float firstNumber, String operation, float secondNumber, float result) {
        Operations dataBaseRequest = new Operations(firstNumber, operation, secondNumber, result);
        dataBaseRequestRepo.save(dataBaseRequest);
    }

    /*@PostMapping(params = GET_DB_REQUESTS)
    public String getCountDbRequests() {
        int count = 0;
        Iterable<Operations> dataBaseRequests = dataBaseRequestRepo.findAll();
        Iterator<Operations> iterator = dataBaseRequests.iterator();
        while (iterator.hasNext()) {
            iterator.hasNext();
            ++count;
        }
        System.out.println(count);

        return CALCULATOR;
    }*/
}