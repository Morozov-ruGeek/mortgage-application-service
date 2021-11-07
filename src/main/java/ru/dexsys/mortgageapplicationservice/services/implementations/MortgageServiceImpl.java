package ru.dexsys.mortgageapplicationservice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;
import ru.dexsys.mortgageapplicationservice.entities.enums.MortgageApplicationStatus;
import ru.dexsys.mortgageapplicationservice.repositories.MortgageRepository;
import ru.dexsys.mortgageapplicationservice.services.ClientService;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.util.Collection;
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

    @Override
    public String creditConfirmation(UUID id, Mortgage mortgage) {
        int minimumDifferenceForApproval = 2;
        Client client = clientService.findById(id).orElseThrow();
        Mortgage clientMortgage = client.getMortgages().stream().filter(mortgage::equals).findFirst().orElseThrow();
        if (mortgageCalculatorService.calculateMonthlyPayment(mortgage.getCreditAmount(), mortgage.getDurationInMonths()).divide(client.getSalary()).intValue() >= minimumDifferenceForApproval) {
            clientMortgage.setStatus(String.valueOf(MortgageApplicationStatus.APPROVED));
            clientService.updateClient(id, client);
            return String.valueOf(MortgageApplicationStatus.APPROVED);
        } else {
            clientMortgage.setStatus(String.valueOf(MortgageApplicationStatus.DENIED));
            clientService.updateClient(id, client);
            return String.valueOf(MortgageApplicationStatus.DENIED);
        }
    }


}
