package com.calculator.controllers;

import com.calculator.entity.DataBaseRequest;
import com.calculator.model.OperationModel;
import com.calculator.repo.DataBaseRequestRepo;
import com.calculator.service.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private OperationModel operationModel = new OperationModel();
    private DataBaseRequest dataBaseRequest = new DataBaseRequest();

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
        model.addAttribute(RESULT, simpleCalculator.getSum(operationModel));
        addRequestToDataBase("sum");
        return CALCULATOR;
    }

    @PostMapping(params = GET_SUBTRACTION_PARAM)
    public String getSubtraction(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        model.addAttribute(RESULT, simpleCalculator.getSubtraction(operationModel));
        addRequestToDataBase("subtraction");
        return CALCULATOR;
    }

    @PostMapping(params = GET_MULTIPLICATION_PARAM)
    public String getMultiplication(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        model.addAttribute(RESULT, simpleCalculator.getMultiplication(operationModel));
        addRequestToDataBase("multiplication");
        return CALCULATOR;
    }

    @PostMapping(params = GET_QUOTIENT_PARAM)
    public String getQuotient(@ModelAttribute(OPERATION_MODEL)  OperationModel operationModel, Model model){
        model.addAttribute(RESULT, simpleCalculator.getQuotient(operationModel));
        addRequestToDataBase("division");
        return CALCULATOR;
    }

    private void addRequestToDataBase(String operation) {
        DataBaseRequest dataBaseRequest = new DataBaseRequest(operation);
        dataBaseRequestRepo.save(dataBaseRequest);
    }

   /* @PostMapping
    public @ResponseBody String addRequest(@RequestParam String operation) {
        DataBaseRequest dataBaseRequest = new DataBaseRequest();
        dataBaseRequest.setOperation(operation);
        System.out.println("SAVED");
        return "Saved";
    }*/
}