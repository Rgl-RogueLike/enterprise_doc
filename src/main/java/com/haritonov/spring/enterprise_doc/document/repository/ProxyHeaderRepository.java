package com.haritonov.spring.enterprise_doc.document.repository;

import com.haritonov.spring.enterprise_doc.document.entity.ProxyHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProxyHeaderRepository extends JpaRepository<ProxyHeader, Integer> {

    List<ProxyHeader> findAllByOrganizationId(Integer organizationId);

    List<ProxyHeader> findAllByEmployeeId(Integer employeeId);
}
