package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private AccountRepository accountRepository;
    @Override
    public JpaRepository<Account, Long> getRepository() {return accountRepository;}
}
