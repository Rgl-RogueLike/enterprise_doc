package com.haritonov.spring.enterprise_doc.document.service;

import com.haritonov.spring.enterprise_doc.document.dto.CreateProxyRequest;
import com.haritonov.spring.enterprise_doc.document.dto.ProxyResponse;
import com.haritonov.spring.enterprise_doc.document.dto.UpdateProxyRequest;

import java.util.List;

public interface ProxyService {

    List<ProxyResponse> getAll();

    ProxyResponse getById(Integer id);

    ProxyResponse create(CreateProxyRequest request);

    ProxyResponse update(Integer id, UpdateProxyRequest request);

    void delete(Integer id);
}
