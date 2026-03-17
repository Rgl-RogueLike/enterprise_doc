package com.haritonov.spring.enterprise_doc.document.entity;

import com.haritonov.spring.enterprise_doc.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proxy_bodies")
@Getter
@Setter
@NoArgsConstructor
public class ProxyBodyItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proxy_id")
    @NotNull
    private ProxyHeader proxyHeader;

    @Column(name = "product_amount")
    @NotNull
    private int productAmount;
}
