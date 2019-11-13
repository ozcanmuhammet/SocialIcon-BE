package com.socialicon.service.account;

import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.dao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountEntity> getAccountsList() {
        List<AccountEntity> accountsList = accountRepository.findAll();
        return accountsList;
    }
}
