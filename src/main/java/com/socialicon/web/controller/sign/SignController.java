package com.socialicon.web.controller.sign;

import com.socialicon.dto.request.SignRequest;
import com.socialicon.service.sign.SignService;
import com.socialicon.util.constant.Endpoints;
import com.socialicon.web.model.SignInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SignController {

    @Autowired
    private SignService signService;

    @CrossOrigin
    @PostMapping(Endpoints.SIGN)
    public ResponseEntity<?> sign(@RequestBody SignInput signInput) throws Exception {
        SignRequest signRequest = new SignRequest(signInput.getEmail(), signInput.getPassword(),  signInput.getFullname());
        return ResponseEntity.ok(signService.sign(signRequest));
    }
}
