package ru.dexsys.mortgageapplicationservice.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dexsys.mortgageapplicationservice.entities.Client;
import ru.dexsys.mortgageapplicationservice.repositories.ClientRepository;
import ru.dexsys.mortgageapplicationservice.services.ClientService;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientRepository.findById(id);
    }
}
