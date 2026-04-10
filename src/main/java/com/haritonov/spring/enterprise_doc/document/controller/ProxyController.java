package com.haritonov.spring.enterprise_doc.document.controller;

import com.haritonov.spring.enterprise_doc.document.dto.CreateProxyRequest;
import com.haritonov.spring.enterprise_doc.document.dto.ProxyItemRequest;
import com.haritonov.spring.enterprise_doc.document.dto.ProxyResponse;
import com.haritonov.spring.enterprise_doc.document.dto.UpdateProxyRequest;
import com.haritonov.spring.enterprise_doc.document.service.ProxyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proxies")
public class ProxyController {

    @Autowired
    ProxyService proxyService;

    @GetMapping
    public ResponseEntity<List<ProxyResponse>> getAll() {
        return ResponseEntity.ok(proxyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProxyResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(proxyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProxyResponse> create(@Valid @RequestBody CreateProxyRequest request) {
        ProxyResponse createdProxy = proxyService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProxy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProxyResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateProxyRequest request) {
        return ResponseEntity.ok(proxyService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        proxyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/body")
    public ResponseEntity<Void> updateBodyItems(
            @PathVariable Integer id,
            @RequestBody List<ProxyItemRequest> items) {
        proxyService.updateBodyItems(id, items);
        return ResponseEntity.noContent().build();
    }
}
