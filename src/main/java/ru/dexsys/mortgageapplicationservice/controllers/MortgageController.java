package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dexsys.mortgageapplicationservice.dtos.ClientDTO;
import ru.dexsys.mortgageapplicationservice.dtos.MortgageApplicationDTO;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.services.ClientService;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.util.Optional;
import java.util.UUID;

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
    public void createMortgageApplication(@RequestBody MortgageApplicationDTO mortgageApplicationDTO) {
//        todo выполнить преобразование DTO в Entities и и раскидать по сервисам
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable UUID id) {
        Client client = clientService.findById(id).orElseThrow();
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
