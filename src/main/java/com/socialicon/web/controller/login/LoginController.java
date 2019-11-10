package com.socialicon.web.controller.login;

import com.socialicon.service.login.LoginService;
import com.socialicon.util.constant.Endpoints;
import com.socialicon.web.model.login.LoginInput;
import com.socialicon.web.request.LoginRequest;
import com.socialicon.web.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @PostMapping(Endpoints.LOGIN)
    public LoginResponse login(@RequestBody LoginInput loginInput) {
        LoginRequest loginRequest = new LoginRequest(loginInput.getEmail(), loginInput.getPassword());
        return loginService.login(loginRequest);
    }
}
