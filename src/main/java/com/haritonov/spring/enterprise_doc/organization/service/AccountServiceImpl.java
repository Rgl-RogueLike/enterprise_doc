package com.haritonov.spring.enterprise_doc.organization.service;

import com.haritonov.spring.enterprise_doc.organization.dto.AccountResponse;
import com.haritonov.spring.enterprise_doc.organization.dto.CreateAccountRequest;
import com.haritonov.spring.enterprise_doc.organization.dto.UpdateAccountRequest;
import com.haritonov.spring.enterprise_doc.organization.entity.Account;
import com.haritonov.spring.enterprise_doc.organization.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    private AccountResponse mapToResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setId(account.getId());
        response.setAccount(account.getAccount());
        response.setBankName(account.getBankName());
        response.setBankIdentityNumber(account.getBankIdentityNumber());
        return response;
    }

    @Override
    public List<AccountResponse> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse getById(Integer id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return mapToResponse(account);
    }

    @Override
    public AccountResponse create(CreateAccountRequest request) {
        Account account = new Account();
        account.setAccount(request.getAccount());
        account.setBankName(request.getBankName());
        account.setBankIdentityNumber(request.getBankIdentityNumber());
        Account savedAccount = accountRepository.save(account);
        return mapToResponse(savedAccount);
    }

    @Override
    public AccountResponse update(Integer id, UpdateAccountRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        account.setAccount(request.getAccount());
        account.setBankName(request.getBankName());
        account.setBankIdentityNumber(request.getBankIdentityNumber());
        Account savedAccount = accountRepository.save(account);
        return mapToResponse(savedAccount);
    }

    @Override
    public void delete(Integer id) {
        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Account not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }
}
