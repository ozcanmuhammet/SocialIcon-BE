package com.socialicon.service;

import com.socialicon.dao.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUserList();
}
