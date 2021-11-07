package ru.dexsys.mortgageapplicationservice.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @Min(value = 0)
    @Max(value = 1200)
    private Integer durationInMonths;

    @Column(name = "monthly_payment")
    private BigDecimal monthlyPayment;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Mortgage() {
    }

    public Mortgage(BigDecimal creditAmount, Integer durationInMonths, BigDecimal monthlyPayment, String status) {
        this.creditAmount = creditAmount;
        this.durationInMonths = durationInMonths;
        this.monthlyPayment = monthlyPayment;
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mortgage: ")
                .append("creditAmount - ").append(creditAmount)
                .append(", duration in months - ").append(durationInMonths)
                .append(", monthly payment = ").append(monthlyPayment)
                .append(", status: ").append(status);
        return builder.toString();
    }
}
