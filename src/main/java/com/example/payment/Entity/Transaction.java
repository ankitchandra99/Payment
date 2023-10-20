package com.example.payment.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private Double amount;
    private Boolean isSuccess;

    public Transaction(Integer transactionId, Double amount, Boolean isSuccess, User user, Refund refund) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.isSuccess = isSuccess;
        this.user = user;
        this.refund = refund;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Refund refund;
}
