package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mortgage")
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @PostMapping("/application")
    public void createMortgageApplication(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable UUID id){

        return null;
    }
}
