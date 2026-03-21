package com.haritonov.spring.enterprise_doc.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {
    private Integer id;
    private String name;
    private String address;
    private String chief;
    private String financialChief;

    private String accountNumber;
    private String bankName;
}
