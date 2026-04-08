package com.haritonov.spring.enterprise_doc.organization.controller;

import com.haritonov.spring.enterprise_doc.organization.dto.CreateOrganizationRequest;
import com.haritonov.spring.enterprise_doc.organization.dto.OrganizationResponse;
import com.haritonov.spring.enterprise_doc.organization.dto.UpdateOrganizationRequest;
import com.haritonov.spring.enterprise_doc.organization.service.OrganizationService;
import com.haritonov.spring.enterprise_doc.product.service.UnitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    private UnitService unitService;

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAll() {
        return ResponseEntity.ok(organizationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(organizationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrganizationResponse> create(@Valid @RequestBody CreateOrganizationRequest request) {
        OrganizationResponse createdOrganization = organizationService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateOrganizationRequest request) {
        return ResponseEntity.ok(organizationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
