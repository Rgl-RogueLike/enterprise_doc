package com.haritonov.spring.enterprise_doc.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUnitRequest {

    @NotNull(message = "Name cannot be empty")
    private String name;
}
