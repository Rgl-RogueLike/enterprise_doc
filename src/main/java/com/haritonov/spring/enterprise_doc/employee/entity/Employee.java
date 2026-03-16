package com.haritonov.spring.enterprise_doc.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "post")
    @NotNull
    private String post;

    @Column(name = "passport_series")
    @NotNull
    private String passportSeries;

    @Column(name = "passport_number")
    @NotNull
    private String passportNumber;

    @Column(name = "passport_issued_by")
    @NotNull
    private String passportIssuedBy;

    @Column(name = "passport_date_of_issue")
    @NotNull
    private LocalDate passportDateOfIssue;
}
