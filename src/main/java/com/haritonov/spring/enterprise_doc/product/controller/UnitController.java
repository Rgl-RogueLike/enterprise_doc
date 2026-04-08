package com.haritonov.spring.enterprise_doc.product.controller;

import com.haritonov.spring.enterprise_doc.product.dto.CreateUnitRequest;
import com.haritonov.spring.enterprise_doc.product.dto.UnitResponse;
import com.haritonov.spring.enterprise_doc.product.dto.UpdateUnitRequest;
import com.haritonov.spring.enterprise_doc.product.service.UnitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public ResponseEntity<List<UnitResponse>> getAll() {
        return ResponseEntity.ok(unitService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(unitService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UnitResponse> create(@Valid @RequestBody CreateUnitRequest request) {
        UnitResponse createUnit = unitService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateUnitRequest request) {
        return ResponseEntity.ok(unitService.update(id, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
