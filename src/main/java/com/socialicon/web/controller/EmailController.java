package com.socialicon.web.controller;

import com.socialicon.common.constants.Endpoints;
import com.socialicon.dto.request.EmailVerifyRequest;
import com.socialicon.service.EmailVerifyService;
import com.socialicon.web.model.EmailInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailVerifyService emailService;

    @CrossOrigin
    @PostMapping(Endpoints.VERIFY_EMAIL)
    public ResponseEntity<?> sign(@RequestBody EmailInput emailInput) throws Exception {
        EmailVerifyRequest emailRequest = new EmailVerifyRequest(emailInput.getEmail());
        return ResponseEntity.ok(emailService.verifyEmail(emailRequest));
    }
}
