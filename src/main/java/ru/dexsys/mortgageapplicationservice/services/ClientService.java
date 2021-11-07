package ru.dexsys.mortgageapplicationservice.services;

import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.entities.Client;

import java.util.Optional;
import java.util.UUID;

@Service
public interface ClientService {
    Optional<Client> findById(UUID id);
    void updateClient(UUID id, Client client);
}
