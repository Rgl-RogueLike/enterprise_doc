package com.haritonov.spring.enterprise_doc.organization.service;

import com.haritonov.spring.enterprise_doc.organization.dto.CreateOrganizationRequest;
import com.haritonov.spring.enterprise_doc.organization.dto.OrganizationResponse;
import com.haritonov.spring.enterprise_doc.organization.dto.UpdateOrganizationRequest;

import java.util.List;

public interface OrganizationService {

    List<OrganizationResponse> getAll();

    OrganizationResponse getById(Integer id);

    OrganizationResponse create(CreateOrganizationRequest request);

    OrganizationResponse update(Integer id, UpdateOrganizationRequest request);

    void delete(Integer id);
}
