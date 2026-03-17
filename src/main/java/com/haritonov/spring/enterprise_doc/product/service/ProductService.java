package com.haritonov.spring.enterprise_doc.product.service;

import com.haritonov.spring.enterprise_doc.product.dto.CreateProductRequest;
import com.haritonov.spring.enterprise_doc.product.dto.ProductResponse;
import com.haritonov.spring.enterprise_doc.product.dto.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAll();

    ProductResponse getById(Integer id);

    ProductResponse create(CreateProductRequest request);

    ProductResponse update(Integer id, UpdateProductRequest request);

    void delete(Integer id);
}
