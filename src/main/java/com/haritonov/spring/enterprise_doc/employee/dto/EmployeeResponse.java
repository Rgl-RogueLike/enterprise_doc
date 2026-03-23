package com.haritonov.spring.enterprise_doc.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private String middleName;
}
