package com.haritonov.spring.enterprise_doc.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrganizationRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "Chief cannot be empty")
    private String chief;

    @NotBlank(message = "Financial chief cannot be empty")
    private String financialChief;

    @NotNull(message = "Account cannot be empty")
    private Integer accountId;
}
