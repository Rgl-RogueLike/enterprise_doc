package com.haritonov.spring.enterprise_doc.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "Account cannot be empty")
    private String account;

    @NotBlank(message = "Bank name cannot be empty")
    private String bankName;

    @NotBlank(message = "Bank identity number cannot be empty")
    private String bankIdentityNumber;
}
