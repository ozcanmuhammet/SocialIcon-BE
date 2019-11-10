package com.socialicon.service.login;

import com.socialicon.web.request.LoginRequest;
import com.socialicon.web.response.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}
