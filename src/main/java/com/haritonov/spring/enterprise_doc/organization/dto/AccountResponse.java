package com.haritonov.spring.enterprise_doc.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Integer id;
    private String account;
    private String bankName;
    private String bankIdentityNumber;
}
