package org.nomantic.coinengine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DepositRequest {

    @NotBlank(message = "the account number can not be blank")
    private String accountNumber;
    @Positive(message = "Deposit must be a positive value")
    private double amount;
}
