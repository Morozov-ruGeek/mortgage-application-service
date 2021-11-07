package ru.dexsys.mortgageapplicationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dexsys.mortgageapplicationservice.entities.Client;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(UUID id);
    void updateClientById(UUID id, Client client);
}
