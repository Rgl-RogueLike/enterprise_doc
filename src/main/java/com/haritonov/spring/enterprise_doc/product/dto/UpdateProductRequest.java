package com.haritonov.spring.enterprise_doc.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateProductRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be greater than 0")
    private Integer price;

    @NotNull(message = "Unit cannot be empty")
    private Integer unitId;
}
