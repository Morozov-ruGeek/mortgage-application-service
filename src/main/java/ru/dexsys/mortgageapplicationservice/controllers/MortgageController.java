package ru.dexsys.mortgageapplicationservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.dexsys.mortgageapplicationservice.services.MortgageService;

@RestController
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }
}
