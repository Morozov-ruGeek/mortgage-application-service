package ru.dexsys.mortgageapplicationservice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.dtos.MortgageApplicationDTO;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;
import ru.dexsys.mortgageapplicationservice.entities.enums.MortgageApplicationStatus;
import ru.dexsys.mortgageapplicationservice.repositories.ClientRepository;
import ru.dexsys.mortgageapplicationservice.services.ClientService;
import ru.dexsys.mortgageapplicationservice.services.MortgageCalculatorService;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final MortgageService mortgageService;
    private final MortgageCalculatorService mortgageCalculatorService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, MortgageService mortgageService, MortgageCalculatorService mortgageCalculatorService) {
        this.clientRepository = clientRepository;
        this.mortgageService = mortgageService;
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public void updateClient(UUID id, Client client) {
        clientRepository.updateClientById(id, client);
    }

    @Override
    public void saveClient(MortgageApplicationDTO mortgageApplicationDTO) {
        Client client = new Client();
        client.setFirstName(mortgageApplicationDTO.getFirstName());
        client.setPatronymic(mortgageApplicationDTO.getPatronymic());
        client.setLastName(mortgageApplicationDTO.getLastName());
        client.setPassport(mortgageApplicationDTO.getPassport());
        client.setBirthday(mortgageApplicationDTO.getBirthday());
        client.setGender(mortgageApplicationDTO.getGender());
        client.setSalary(mortgageApplicationDTO.getSalary());
        Mortgage mortgage = new Mortgage(mortgageApplicationDTO.getCreditAmount(),
                mortgageApplicationDTO.getDurationInMonths(),
                mortgageCalculatorService.calculateMonthlyPayment(mortgageApplicationDTO.getCreditAmount(), mortgageApplicationDTO.getDurationInMonths()),
                String.valueOf(MortgageApplicationStatus.PROCESSING));
        Collection<Mortgage> mortgages = new ArrayList<>(Arrays.asList(mortgage));
        client.setMortgages(mortgages);
        clientRepository.saveClient(client);
    }
}
