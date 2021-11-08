package ru.dexsys.mortgageapplicationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;

import java.util.Optional;

@Repository
public interface MortgageRepository extends JpaRepository<Mortgage, Long> {
    Optional<Mortgage> findById(Long aLong);
}
