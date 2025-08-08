package org.nomantic.coinengine.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountHolderName;
    @Column(nullable = false)
    protected double balance;

    // Abstract method (Polymorphism)
    public abstract String getAccountType();

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance <= 0 || amount > this.balance) {
            throw new RuntimeException("Insufficient balance");
        }
        else {
            this.balance -= amount;
        }
    }

}
