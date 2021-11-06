package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;

@RestController
@RequestMapping("/api/v1/calculate")
public class MortgageCalculatorController {

    private final MortgageCalculatorService mortgageCalculatorService;

    @Autowired
    public MortgageCalculatorController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

}
