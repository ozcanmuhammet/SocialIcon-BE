package com.socialicon.web.controller.login;

import com.socialicon.service.login.LoginService;
import com.socialicon.util.constant.Endpoints;
import com.socialicon.web.model.LoginInput;
import com.socialicon.dto.request.LoginRequest;

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

    @CrossOrigin
    @PostMapping(Endpoints.LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginInput loginInput) {
        LoginRequest loginRequest = new LoginRequest(loginInput.getEmail(), loginInput.getPassword());
        return ResponseEntity.ok(loginService.login(loginRequest));
    }
}
