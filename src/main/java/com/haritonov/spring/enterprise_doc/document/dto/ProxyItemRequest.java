package com.haritonov.spring.enterprise_doc.document.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProxyItemRequest {

    @NotNull(message = "Product cannot be empty")
    private Integer productId;

    @NotNull(message = "Amount cannot be empty")
    @Positive(message = "Amount must be positive")
    private int productAmount;

}
