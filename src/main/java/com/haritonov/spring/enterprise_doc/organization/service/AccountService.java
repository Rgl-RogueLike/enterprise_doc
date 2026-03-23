package com.haritonov.spring.enterprise_doc.organization.service;

import com.haritonov.spring.enterprise_doc.organization.dto.AccountResponse;
import com.haritonov.spring.enterprise_doc.organization.dto.CreateAccountRequest;
import com.haritonov.spring.enterprise_doc.organization.dto.UpdateAccountRequest;

import java.util.List;

public interface AccountService {

    List<AccountResponse> getAll();

    AccountResponse getById(Integer id);

    AccountResponse create(CreateAccountRequest request);

    AccountResponse update(Integer id, UpdateAccountRequest request);

    void delete(Integer id);
}
