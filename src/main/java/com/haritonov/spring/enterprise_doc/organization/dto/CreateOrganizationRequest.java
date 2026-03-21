package com.haritonov.spring.enterprise_doc.organization.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrganizationRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Chief cannot be empty")
    private String chief;

    @NotNull(message = "Financial chief cannot be empty")
    private String financialChief;

    @NotNull(message = "Account cannot be empty")
    private Integer accountId;
}
