package com.haritonov.spring.enterprise_doc.employee.service;

import com.haritonov.spring.enterprise_doc.employee.dto.CreateEmployeeRequest;
import com.haritonov.spring.enterprise_doc.employee.dto.EmployeeResponse;
import com.haritonov.spring.enterprise_doc.employee.dto.UpdateEmployeeRequest;
import com.haritonov.spring.enterprise_doc.employee.entity.Employee;
import com.haritonov.spring.enterprise_doc.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    private EmployeeResponse mapToResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        if (employee.getMiddleName() != null) {
            response.setMiddleName(employee.getMiddleName());
        }
        return response;
    }

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapToResponse(employee);
    }

    @Override
    public EmployeeResponse create(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setMiddleName(request.getMiddleName());
        employee.setPost(request.getPost());
        employee.setPassportSeries(request.getPassportSeries());
        employee.setPassportNumber(request.getPassportNumber());
        employee.setPassportIssuedBy(request.getPassportIssuedBy());
        employee.setPassportDateOfIssue(request.getPassportDateOfIssue());
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponse(savedEmployee);
    }

    @Override
    public EmployeeResponse update(Integer id, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setMiddleName(request.getMiddleName());
        employee.setPost(request.getPost());
        employee.setPassportSeries(request.getPassportSeries());
        employee.setPassportNumber(request.getPassportNumber());
        employee.setPassportIssuedBy(request.getPassportIssuedBy());
        employee.setPassportDateOfIssue(request.getPassportDateOfIssue());
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponse(savedEmployee);
    }

    @Override
    public void delete(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
