package com.haritonov.spring.enterprise_doc.organization.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAccountRequest {

    @NotNull(message = "Account cannot be empty")
    private String account;

    @NotNull(message = "Bank name cannot be empty")
    private String bankName;

    @NotNull(message = "Bank identity number cannot be empty")
    private String bankIdentityNumber;
}
