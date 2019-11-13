package com.socialicon.service.login;

import com.socialicon.dto.request.LoginRequest;
import com.socialicon.dto.response.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}
