package com.socialicon.web.controller;

import com.socialicon.web.model.LoginInput;
import com.socialicon.common.constants.Endpoints;
import com.socialicon.dto.request.LoginRequest;
import com.socialicon.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(Endpoints.LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginInput loginInput) {
        LoginRequest loginRequest = new LoginRequest(loginInput.getEmail(), loginInput.getPassword());
        return ResponseEntity.ok(loginService.login(loginRequest));
    }
}
