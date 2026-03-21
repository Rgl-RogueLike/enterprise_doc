package com.haritonov.spring.enterprise_doc.organization.service;

import com.haritonov.spring.enterprise_doc.organization.dto.CreateOrganizationRequest;
import com.haritonov.spring.enterprise_doc.organization.dto.OrganizationResponse;
import com.haritonov.spring.enterprise_doc.organization.dto.UpdateOrganizationRequest;
import com.haritonov.spring.enterprise_doc.organization.entity.Account;
import com.haritonov.spring.enterprise_doc.organization.entity.Organization;
import com.haritonov.spring.enterprise_doc.organization.repository.AccountRepository;
import com.haritonov.spring.enterprise_doc.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private AccountRepository accountRepository;

    private OrganizationResponse mapToResponse(Organization organization) {
        OrganizationResponse response = new OrganizationResponse();
        response.setId(organization.getId());
        response.setName(organization.getName());
        response.setAddress(organization.getAddress());
        response.setChief(organization.getChief());
        response.setFinancialChief(organization.getFinancialChief());

        if(organization.getAccount() != null) {
            response.setAccountNumber(organization.getAccount().getAccount());
            response.setBankName(organization.getAccount().getBankName());
        }
        return response;
    }

    @Override
    public List<OrganizationResponse> getAll() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationResponse getById(Integer id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
        return mapToResponse(organization);
    }

    @Override
    public OrganizationResponse create(CreateOrganizationRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + request.getAccountId()));

        Organization organization = new Organization();
        organization.setName(request.getName());
        organization.setAddress(request.getAddress());
        organization.setChief(request.getChief());
        organization.setFinancialChief(request.getFinancialChief());
        organization.setAccount(account);

        Organization savedOrganization = organizationRepository.save(organization);
        return mapToResponse(savedOrganization);
    }

    @Override
    public OrganizationResponse update(Integer id, UpdateOrganizationRequest request) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        organization.setName(request.getName());
        organization.setAddress(request.getAddress());
        organization.setChief(request.getChief());
        organization.setFinancialChief(request.getFinancialChief());
        organization.setAccount(account);

        Organization savedOrganization = organizationRepository.save(organization);
        return mapToResponse(savedOrganization);
    }

    @Override
    public void delete(Integer id) {
        if (!organizationRepository.existsById(id)) {
            throw new RuntimeException("Organization not found with id: " + id);
        }
        organizationRepository.deleteById(id);
    }
}
