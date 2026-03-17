package com.haritonov.spring.enterprise_doc.organization.repository;

import com.haritonov.spring.enterprise_doc.organization.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
