package com.haritonov.spring.enterprise_doc.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUnitRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;
}
