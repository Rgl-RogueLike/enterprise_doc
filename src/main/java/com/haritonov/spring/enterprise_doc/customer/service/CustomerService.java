package com.haritonov.spring.enterprise_doc.customer.service;

import com.haritonov.spring.enterprise_doc.customer.dto.CreateCustomerRequest;
import com.haritonov.spring.enterprise_doc.customer.dto.CustomerResponse;
import com.haritonov.spring.enterprise_doc.customer.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAll();

    CustomerResponse getById(Integer id);

    CustomerResponse create(CreateCustomerRequest request);

    CustomerResponse update(Integer id, UpdateCustomerRequest request);

    void delete(Integer id);
}
