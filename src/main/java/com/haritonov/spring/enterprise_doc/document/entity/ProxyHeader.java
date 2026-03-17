package com.haritonov.spring.enterprise_doc.document.entity;

import com.haritonov.spring.enterprise_doc.customer.entity.Customer;
import com.haritonov.spring.enterprise_doc.employee.entity.Employee;
import com.haritonov.spring.enterprise_doc.organization.entity.Organization;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proxies")
@Getter
@Setter
@NoArgsConstructor
public class ProxyHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    @NotNull
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @NotNull
    private Employee employee;

    @Column(name = "date_of_issue")
    @NotNull
    private LocalDate dateOfIssue;

    @Column(name = "is_valid_until")
    @NotNull
    private LocalDate isValidUntil;

    @OneToMany(mappedBy = "proxyHeader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProxyBodyItem> bodyItems = new ArrayList<>();
}
