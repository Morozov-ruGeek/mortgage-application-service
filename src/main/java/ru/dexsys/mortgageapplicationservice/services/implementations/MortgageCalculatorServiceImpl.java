package ru.dexsys.mortgageapplicationservice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.repositories.MortgageCalculatorRepository;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;

import java.math.BigDecimal;

@Service
public class MortgageCalculatorServiceImpl implements MortgageCalculatorService {

    private final double INTEREST_RATE = 15;

    private final MortgageCalculatorRepository mortgageCalculatorRepository;

    @Autowired
    public MortgageCalculatorServiceImpl(MortgageCalculatorRepository mortgageCalculatorRepository) {
        this.mortgageCalculatorRepository = mortgageCalculatorRepository;
    }

    /**
     * @param creditAmount
     * @param durationInMonths
     * @return monthlyPayment
     * calculation for annuity payment
     */


    @Override
    public BigDecimal calculateMonthlyPayment(BigDecimal creditAmount, Integer durationInMonths) {
        double creditAmountInDouble = Double.parseDouble(String.valueOf(creditAmount));
        double monthlyPaymentInDouble = creditAmountInDouble * (INTEREST_RATE * (INTEREST_RATE / 1 + INTEREST_RATE) * durationInMonths - 1);
        return BigDecimal.valueOf(monthlyPaymentInDouble);
    }


}