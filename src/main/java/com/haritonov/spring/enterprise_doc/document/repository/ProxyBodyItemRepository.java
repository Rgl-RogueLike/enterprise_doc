package com.haritonov.spring.enterprise_doc.document.repository;

import com.haritonov.spring.enterprise_doc.document.entity.ProxyBodyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProxyBodyItemRepository extends JpaRepository<ProxyBodyItem, Integer> {

}
