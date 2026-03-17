package com.haritonov.spring.enterprise_doc.employee.repository;

import com.haritonov.spring.enterprise_doc.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
