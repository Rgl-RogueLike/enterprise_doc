package com.haritonov.spring.enterprise_doc.product.service;

import com.haritonov.spring.enterprise_doc.product.dto.CreateUnitRequest;
import com.haritonov.spring.enterprise_doc.product.dto.UnitResponse;
import com.haritonov.spring.enterprise_doc.product.dto.UpdateUnitRequest;

import java.util.List;

public interface UnitService {

    List<UnitResponse> getAll();

    UnitResponse getById(Integer id);

    UnitResponse create(CreateUnitRequest request);

    UnitResponse update(Integer id, UpdateUnitRequest request);

    void delete(Integer id);
}
