package com.haritonov.spring.enterprise_doc.organization.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account")
    @NotNull
    private String account;

    @Column(name = "bank_name")
    @NotNull
    private String bankName;

    @Column(name = "bank_identity_number")
    @NotNull
    private String bankIdentityNumber;
}
