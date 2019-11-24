package com.socialicon.service.user;

import com.socialicon.dao.entity.UserEntity;
import com.socialicon.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUserList() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }
}

