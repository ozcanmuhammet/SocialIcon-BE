package com.socialicon.service.login;

import com.socialicon.util.constant.JwtUtil;
import com.socialicon.web.request.LoginRequest;
import com.socialicon.web.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // TODO
        // Login Request null and empty control


        // User control

        // canLogin

        String token = jwtUtil.generateToken(loginRequest);
        return new LoginResponse(token);
    }
}
