package com.socialicon.dao.repository;

import com.socialicon.dao.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByEmail(String email);

    AccountEntity save(AccountEntity accountEntitiy);
}
