package ru.dexsys.mortgageapplicationservice.services;

import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;

import java.util.UUID;

@Service
public interface MortgageService {
    String creditConfirmation(UUID id, Mortgage mortgage);
}
