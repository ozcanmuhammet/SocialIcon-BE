package com.socialicon.service.account;

import com.socialicon.dao.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAccountsList();
}
