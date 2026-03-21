package com.haritonov.spring.enterprise_doc.product.service;

import com.haritonov.spring.enterprise_doc.product.dto.CreateUnitRequest;
import com.haritonov.spring.enterprise_doc.product.dto.UnitResponse;
import com.haritonov.spring.enterprise_doc.product.dto.UpdateUnitRequest;
import com.haritonov.spring.enterprise_doc.product.entity.Unit;
import com.haritonov.spring.enterprise_doc.product.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UnitServiceImpl implements UnitService{

    @Autowired
    UnitRepository unitRepository;

    private UnitResponse mapToResponse(Unit unit) {
        return new UnitResponse(unit.getId(), unit.getName());
    }

    @Override
    public List<UnitResponse> getAll() {
        List<Unit> units = unitRepository.findAll();
        return units.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UnitResponse getById(Integer id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + id));
        return mapToResponse(unit);
    }

    @Override
    public UnitResponse create(CreateUnitRequest request) {
        Unit unit = new Unit();
        unit.setName(request.getName());
        return mapToResponse(unit);
    }

    @Override
    public UnitResponse update(Integer id, UpdateUnitRequest request) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found by id: " + id));
        unit.setName(request.getName());

        Unit savedUnit = unitRepository.save(unit);
        return mapToResponse(savedUnit);
    }

    @Override
    public void delete(Integer id) {
        if (id == 0) {
            throw new RuntimeException("Cannot delete default unit (ID = 0)");
        }
        if (!unitRepository.existsById(id)) {
            throw new RuntimeException("Unit not found with id: " + id);
        }
        unitRepository.deleteById(id);
    }
}
