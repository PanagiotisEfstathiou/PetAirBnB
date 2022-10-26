package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.repository.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private AccountRepository accountRepository;
    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
