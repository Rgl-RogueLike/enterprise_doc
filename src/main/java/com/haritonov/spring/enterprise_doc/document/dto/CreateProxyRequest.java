package com.haritonov.spring.enterprise_doc.document.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateProxyRequest {

    @NotNull(message = "Organization id cannot be empty")
    private Integer organizationId;

    @NotNull(message = "Customer id cannot be empty")
    private Integer customerId;

    @NotNull(message = "Employee id cannot be empty")
    private Integer employeeId;

    @NotNull(message = "Date of issue cannot be empty")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfIssue;

    @NotNull(message = "Valid until date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate isValidUntil;

    @NotEmpty(message = "Body items cannot be empty")
    private List<ProxyItemRequest> bodyItems;
}
