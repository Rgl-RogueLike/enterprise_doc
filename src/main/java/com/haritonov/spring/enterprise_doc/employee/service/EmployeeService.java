package com.haritonov.spring.enterprise_doc.employee.service;

import com.haritonov.spring.enterprise_doc.employee.dto.CreateEmployeeRequest;
import com.haritonov.spring.enterprise_doc.employee.dto.EmployeeResponse;
import com.haritonov.spring.enterprise_doc.employee.dto.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAll();

    EmployeeResponse getById(Integer id);

    EmployeeResponse create(CreateEmployeeRequest request);

    EmployeeResponse update(Integer id, UpdateEmployeeRequest request);

    void delete(Integer id);
}
