package com.haritonov.spring.enterprise_doc.product.service;

import com.haritonov.spring.enterprise_doc.AbstractIntegrationTest;
import com.haritonov.spring.enterprise_doc.product.dto.CreateProductRequest;
import com.haritonov.spring.enterprise_doc.product.dto.ProductResponse;
import com.haritonov.spring.enterprise_doc.product.entity.Unit;
import com.haritonov.spring.enterprise_doc.product.repository.UnitRepository;
import com.haritonov.spring.enterprise_doc.util.TestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceTest extends AbstractIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private UnitRepository unitRepository;

    private Integer existingUnitId;

    @BeforeEach
    public void setUp() {
        var unit = new Unit();
        unit.setName(TestDataBuilder.createUnitName());
        unit = unitRepository.save(unit);
        existingUnitId = unit.getId();
    }

    @Test
    void testCreateProduct() {
        CreateProductRequest request = TestDataBuilder.buildCreateProductRequest(existingUnitId);
        ProductResponse response = productService.create(request);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getId());
        Assertions.assertEquals(request.getName(), response.getName());
        Assertions.assertEquals(request.getPrice(), response.getPrice());
    }

    @Test
    void testGetAllProducts() {
        int countProducts = 0;
        for(int i = 0; i < 100; i++) {
           productService.create(TestDataBuilder.buildCreateProductRequest(existingUnitId));
           countProducts++;
        }

        List<ProductResponse> products = productService.getAll();
        Assertions.assertEquals(countProducts, products.size());
    }
}
