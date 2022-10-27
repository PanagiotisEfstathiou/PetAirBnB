package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.service.AccountService;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResponseEntity<ApiResponse<Account>> findAccounts(){
        return ResponseEntity.ok(ApiResponse.<Account>builder().build());
    }
}
