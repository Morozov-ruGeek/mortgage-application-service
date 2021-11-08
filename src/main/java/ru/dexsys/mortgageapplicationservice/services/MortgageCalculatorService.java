package ru.dexsys.mortgageapplicationservice.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface MortgageCalculatorService {
    BigDecimal calculateMonthlyPayment(BigDecimal creditAmount, Integer durationInMonths);
}
