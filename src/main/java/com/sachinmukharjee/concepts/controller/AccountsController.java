package com.sachinmukharjee.concepts.controller;


import com.sachinmukharjee.concepts.entity.Accounts;
import com.sachinmukharjee.concepts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/accounts")
@AllArgsConstructor
public class AccountsController {

    private IAccountsService accountsService;

    @GetMapping
    public List<Accounts> getAllAccount(){
        return accountsService.getAllAccounts();
    }
}
