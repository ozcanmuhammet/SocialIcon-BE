package com.socialicon.service.jwt;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.dao.repository.AccountRepository;
import com.socialicon.common.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity user = accountRepository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException(ErrorCodes.USER_NOT_FOUND.getErrorMessage() + email);
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
