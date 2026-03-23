package com.haritonov.spring.enterprise_doc.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateEmployeeRequest {

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Post cannot be empty")
    private String post;

    @NotBlank(message = "Passport series cannot be empty")
    private String passportSeries;

    @NotBlank(message = "Passport number cannot be empty")
    private String passportNumber;

    @NotBlank(message = "Passport issue cannot be empty")
    private String passportIssuedBy;

    @NotNull(message = "Passport date of Issue cannot be empty")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate passportDateOfIssue;
}
