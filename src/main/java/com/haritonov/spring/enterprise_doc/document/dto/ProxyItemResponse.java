package com.haritonov.spring.enterprise_doc.document.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxyItemResponse {
    private Integer id;
    private String productName;
    private Integer productAmount;
    private Integer price;
}
