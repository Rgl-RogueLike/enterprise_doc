package com.haritonov.spring.enterprise_doc.document.service;

import com.haritonov.spring.enterprise_doc.customer.entity.Customer;
import com.haritonov.spring.enterprise_doc.customer.repository.CustomerRepository;
import com.haritonov.spring.enterprise_doc.document.dto.*;
import com.haritonov.spring.enterprise_doc.document.entity.ProxyBodyItem;
import com.haritonov.spring.enterprise_doc.document.entity.ProxyHeader;
import com.haritonov.spring.enterprise_doc.document.repository.ProxyHeaderRepository;
import com.haritonov.spring.enterprise_doc.employee.entity.Employee;
import com.haritonov.spring.enterprise_doc.employee.repository.EmployeeRepository;
import com.haritonov.spring.enterprise_doc.organization.entity.Organization;
import com.haritonov.spring.enterprise_doc.organization.repository.OrganizationRepository;
import com.haritonov.spring.enterprise_doc.product.entity.Product;
import com.haritonov.spring.enterprise_doc.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyHeaderRepository proxyHeaderRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProductRepository productRepository;

    private ProxyItemResponse mapToItemResponse(ProxyBodyItem item) {
        ProxyItemResponse response = new ProxyItemResponse();
        response.setId(item.getId());
        response.setProductName(item.getProduct().getName());
        response.setProductAmount(item.getProductAmount());
        response.setPrice(item.getProduct().getPrice());
        return response;
    }

    private ProxyResponse mapToResponse(ProxyHeader header) {
        List<ProxyItemResponse> items = header.getBodyItems().stream()
                .map(this::mapToItemResponse)
                .toList();

        ProxyResponse response = new ProxyResponse();
        response.setId(header.getId());
        response.setOrganizationName(header.getOrganization().getName());
        response.setCustomerName(header.getCustomer().getName());
        response.setEmployeeName(header.getEmployee().getLastName() + " " + header.getEmployee().getFirstName());
        response.setDateOfIssue(header.getDateOfIssue());
        response.setIsValidUntil(header.getIsValidUntil());
        response.setBodyItems(items);

        return response;
    }

    @Override
    public List<ProxyResponse> getAll() {
        List<ProxyHeader> proxyHeaders = proxyHeaderRepository.findAll();
        return proxyHeaders.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProxyResponse getById(Integer id) {
        ProxyHeader proxyHeader = proxyHeaderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proxy not found with id: " + id));
        return mapToResponse(proxyHeader);
    }

    @Override
    @Transactional
    public ProxyResponse create(CreateProxyRequest request) {
        Organization organization = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        ProxyHeader header = new ProxyHeader();
        header.setOrganization(organization);
        header.setCustomer(customer);
        header.setEmployee(employee);
        header.setDateOfIssue(request.getDateOfIssue());
        header.setIsValidUntil(request.getIsValidUntil());

        List<ProxyBodyItem> items = new ArrayList<>();
        for (ProxyItemRequest itemRequest : request.getBodyItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemRequest.getProductId()));
            ProxyBodyItem item = new ProxyBodyItem();
            item.setProduct(product);
            item.setProxyHeader(header);
            item.setProductAmount(itemRequest.getProductAmount());
            items.add(item);
        }

        header.setBodyItems(items);
        ProxyHeader savedHeader = proxyHeaderRepository.save(header);
        return mapToResponse(savedHeader);
    }

    @Override
    @Transactional
    public ProxyResponse update(Integer id, UpdateProxyRequest request) {
        ProxyHeader header = proxyHeaderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proxy not found with id: " + id));
        Organization organization = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        header.setOrganization(organization);
        header.setCustomer(customer);
        header.setEmployee(employee);
        header.setDateOfIssue(request.getDateOfIssue());
        header.setIsValidUntil(request.getIsValidUntil());

        header.getBodyItems().clear();
        List<ProxyBodyItem> newItems = new ArrayList<>();
        for (ProxyItemRequest itemRequest : request.getBodyItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemRequest.getProductId()));
            ProxyBodyItem item = new ProxyBodyItem();
            item.setProduct(product);
            item.setProxyHeader(header);
            item.setProductAmount(itemRequest.getProductAmount());
            newItems.add(item);
        }
        header.setBodyItems(newItems);
        ProxyHeader savedHeader = proxyHeaderRepository.save(header);
        return mapToResponse(savedHeader);
    }

    @Override
    public void delete(Integer id) {
        if (!proxyHeaderRepository.existsById(id)) {
            throw new RuntimeException("Proxy not found with id: " + id);
        }
        proxyHeaderRepository.deleteById(id);
    }
}
