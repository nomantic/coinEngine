package org.nomantic.coinengine.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountCreateRequest {

    @NotBlank(message = "account holder name cannot be blank")
    private String accountHolderName;

    @NotBlank(message = "account type must be SAVINGS or CHECKING")
    private String accountType;
}
