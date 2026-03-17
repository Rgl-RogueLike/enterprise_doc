package com.haritonov.spring.enterprise_doc.organization.repository;

import com.haritonov.spring.enterprise_doc.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
