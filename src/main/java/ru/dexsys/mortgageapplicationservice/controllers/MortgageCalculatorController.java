package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dexsys.mortgageapplicationservice.dtos.MortgageApplicationDTO;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calculate")
public class MortgageCalculatorController {

    private final MortgageCalculatorService mortgageCalculatorService;

    @Autowired
    public MortgageCalculatorController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

    public BigDecimal calculateMonthlyPayment(@RequestBody MortgageApplicationDTO mortgageApplicationDTO){
        BigDecimal creditAmount = mortgageApplicationDTO.getCreditAmount();
        Integer durationInMonths = mortgageApplicationDTO.getDurationInMonths();
        return mortgageCalculatorService.calculateMonthlyPayment(creditAmount, durationInMonths);
    }
}
