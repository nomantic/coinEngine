package org.nomantic.coinengine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class WithdrawRequest {

    @NotBlank(message = "account number can not be blank")
    private String accountNumber;

    @Positive(message = "Withdraw value must be positive")
    private double amount;
}
