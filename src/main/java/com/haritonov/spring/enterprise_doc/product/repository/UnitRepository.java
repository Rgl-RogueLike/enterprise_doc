package com.haritonov.spring.enterprise_doc.product.repository;

import com.haritonov.spring.enterprise_doc.product.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
