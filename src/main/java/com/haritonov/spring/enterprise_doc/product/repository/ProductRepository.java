package com.haritonov.spring.enterprise_doc.product.repository;

import com.haritonov.spring.enterprise_doc.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByUnitId(Integer unitId);

}
