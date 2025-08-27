package org.nomantic.coinengine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransferRequest {

    @NotBlank(message = "account number can not be blank")
    private String fromAccountNUmber;

    @NotBlank(message = "account number can not be blank")
    private String toAccountNUmber;

    @Positive(message = "amount must be a positive value")
    private double amount;
}
