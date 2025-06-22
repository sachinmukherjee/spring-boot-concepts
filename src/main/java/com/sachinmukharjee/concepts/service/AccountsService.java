package com.sachinmukharjee.concepts.service;


import com.sachinmukharjee.concepts.entity.Accounts;
import com.sachinmukharjee.concepts.repository.IAccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountsService implements IAccountsService {

    private IAccountsRepository accountsRepository;


    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }
}
