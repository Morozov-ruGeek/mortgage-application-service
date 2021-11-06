package ru.dexsys.mortgageapplicationservice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;
import ru.dexsys.mortgageapplicationservice.repositories.MortgageRepository;
import ru.dexsys.mortgageapplicationservice.services.ClientService;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class MortgageServiceImpl implements MortgageService {

    private final MortgageRepository mortgageRepository;
    private final MortgageCalculatorService mortgageCalculatorService;
    private final ClientService clientService;

    @Autowired
    public MortgageServiceImpl(MortgageRepository mortgageRepository,
                               MortgageCalculatorService mortgageCalculatorService,
                               ClientService clientService) {
        this.mortgageRepository = mortgageRepository;
        this.mortgageCalculatorService = mortgageCalculatorService;
        this.clientService = clientService;
    }

//    todo check method added parameters in calculateMonthlyPayment, getMortgage
    public String creditConfirmation(UUID id) {
        Client client = clientService.findById(id).orElseThrow();
        Mortgage mortgage = client.getMortgages().stream().filter();
        if (client.getSalary() >= 2 * mortgageCalculatorService.calculateMonthlyPayment()){

        }
            return "Empty string";
    }


}
