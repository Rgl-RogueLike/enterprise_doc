package com.haritonov.spring.enterprise_doc.customer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    @NotBlank(message = "Name is required")
    private String name;
}
