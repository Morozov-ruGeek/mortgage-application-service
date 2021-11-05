package ru.dexsys.mortgageapplicationservice.entities;

import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.dexsys.mortgageapplicationservice.entities.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport")
    private Integer passport;

    @Column(name = "client_birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "salary")
    @Min(value = 0)
    @Max(value = 1000000000)
    private BigDecimal salary;

    @ManyToMany
    @JoinTable(name = "mortgage",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "mortgage_id"))
    private Collection<Mortgage> mortgages;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
