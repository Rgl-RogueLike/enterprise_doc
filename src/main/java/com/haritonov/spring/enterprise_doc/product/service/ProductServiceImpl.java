package com.haritonov.spring.enterprise_doc.product.service;

import com.haritonov.spring.enterprise_doc.product.dto.CreateProductRequest;
import com.haritonov.spring.enterprise_doc.product.dto.ProductResponse;
import com.haritonov.spring.enterprise_doc.product.dto.UpdateProductRequest;
import com.haritonov.spring.enterprise_doc.product.entity.Product;
import com.haritonov.spring.enterprise_doc.product.entity.Unit;
import com.haritonov.spring.enterprise_doc.product.repository.ProductRepository;
import com.haritonov.spring.enterprise_doc.product.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UnitRepository unitRepository;

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        if (product.getUnit() != null) {
            response.setUnitName(product.getUnit().getName());
        } else {
            response.setUnitName("Не указано");
        }
        return response;
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    @Override
    public ProductResponse create(CreateProductRequest request) {
        Unit unit = unitRepository.findById(request.getUnitId())
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + request.getUnitId()));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setUnit(unit);

        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }

    @Override
    public ProductResponse update(Integer id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Unit unit = unitRepository.findById(request.getUnitId())
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + request.getUnitId()));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setUnit(unit);

        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }

    @Override
    public void delete(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
