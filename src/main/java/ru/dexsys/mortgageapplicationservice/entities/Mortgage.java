package ru.dexsys.mortgageapplicationservice.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "mortgage")
public class Mortgage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "months_duration")
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
