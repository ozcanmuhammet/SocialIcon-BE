package com.socialicon.web.controller.account;

import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountEntity> getAccounts() {
        return accountService.getAccountsList();
    }
}
