package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dexsys.mortgageapplicationservice.dtos.ClientDTO;
import ru.dexsys.mortgageapplicationservice.dtos.MortgageApplicationDTO;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;
import ru.dexsys.mortgageapplicationservice.entities.enums.MortgageApplicationStatus;
import ru.dexsys.mortgageapplicationservice.error_handling.InvalidDataException;
import ru.dexsys.mortgageapplicationservice.error_handling.ResourceNotFoundException;
import ru.dexsys.mortgageapplicationservice.services.ClientService;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/mortgage")
public class MortgageController {

    private final MortgageService mortgageService;
    private final ClientService clientService;

    @Autowired
    public MortgageController(MortgageService mortgageService, ClientService clientService) {
        this.mortgageService = mortgageService;
        this.clientService = clientService;
    }

    @PostMapping("/application")
    public void createMortgageApplication(@RequestBody @Validated MortgageApplicationDTO mortgageApplicationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        Mortgage mortgage = new Mortgage();
        mortgage.setCreditAmount(mortgageApplicationDTO.getCreditAmount());
        mortgage.setDurationInMonths(mortgageApplicationDTO.getDurationInMonths());
        mortgage.setStatus(String.valueOf(MortgageApplicationStatus.PROCESSING));
        clientService.saveClient(mortgageApplicationDTO);
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable UUID id) {
        Client client = clientService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client doesn't exist"));
        return new ClientDTO.ClientDTOBuilder()
                .setFirstName(client.getFirstName())
                .setPatronymic(client.getPatronymic())
                .setLastName(client.getLastName())
                .setGender(client.getGender())
                .setPassport(client.getPassport())
                .setSalary(client.getSalary())
                .setMortgages(client.getMortgages())
                .build();
    }
}
