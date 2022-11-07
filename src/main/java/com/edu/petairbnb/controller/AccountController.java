package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.model.Expertise;
import com.edu.petairbnb.service.AccountService;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Accounts")
public class AccountController extends AbstractController<Account> {

    private final AccountService accountService;


    protected BaseService<Account> getBaseService() {
        return accountService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Account> getAccounts(){
        return this.accountService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("getBy/{exp}")
    public Account getByExpertise(@PathVariable("exp") Expertise exp){
        return this.accountService.findByExpertise(exp);
    }
}
