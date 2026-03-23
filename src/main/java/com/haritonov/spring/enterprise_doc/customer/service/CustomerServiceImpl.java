package com.haritonov.spring.enterprise_doc.customer.service;

import com.haritonov.spring.enterprise_doc.customer.dto.CreateCustomerRequest;
import com.haritonov.spring.enterprise_doc.customer.dto.CustomerResponse;
import com.haritonov.spring.enterprise_doc.customer.dto.UpdateCustomerRequest;
import com.haritonov.spring.enterprise_doc.customer.entity.Customer;
import com.haritonov.spring.enterprise_doc.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    private CustomerResponse mapToResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setName(customer.getName());
        return response;
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return mapToResponse(customer);
    }

    @Override
    public CustomerResponse create(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        Customer savedCustomer = customerRepository.save(customer);
        return mapToResponse(savedCustomer);
    }

    @Override
    public CustomerResponse update(Integer id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        customer.setName(request.getName());
        Customer savedCustomer = customerRepository.save(customer);
        return mapToResponse(savedCustomer);
    }

    @Override
    public void delete(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }
}
