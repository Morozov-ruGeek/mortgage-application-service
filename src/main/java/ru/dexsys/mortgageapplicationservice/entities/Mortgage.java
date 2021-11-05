package ru.dexsys.mortgageapplicationservice.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "mortgage")
public class Mortgage {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "months_duration")
    @Min(value = 0)
    @Max(value = 1200)
    private Integer durationInMonths;

    @ManyToMany
    @JoinTable(name = "mortgage_status",
            joinColumns = @JoinColumn(name = "mortgage_id"),
            inverseJoinColumns = @JoinColumn(name = "mortgage_status_id"))
    private Collection<MortgageStatus> statuses;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
