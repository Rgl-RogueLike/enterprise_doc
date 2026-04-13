package com.haritonov.spring.enterprise_doc.util;

import com.github.javafaker.Faker;
import com.haritonov.spring.enterprise_doc.product.dto.CreateProductRequest;
import com.haritonov.spring.enterprise_doc.product.dto.CreateUnitRequest;

import java.util.concurrent.ThreadLocalRandom;

public class TestDataBuilder {
    private static final Faker faker = new Faker();
    private static final int MIN_PRICE = 10;
    private static final int MAX_PRICE = 10_000;

    public static CreateProductRequest buildCreateProductRequest(Integer unitId) {
        CreateProductRequest request = new CreateProductRequest();
        request.setName(faker.commerce().productName());
        request.setPrice(ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE));
        request.setUnitId(unitId);
        return request;
    }

    public static CreateUnitRequest buildCreateUnitRequest() {
        CreateUnitRequest request = new CreateUnitRequest();
        request.setName(faker.food().measurement());
        return request;
    }

    public static String createUnitName() {
        return faker.food().measurement();
    }
}
