package com.socialicon.service.login;

import com.socialicon.dao.entity.UserEntity;
import com.socialicon.dao.repository.UserRepository;
import com.socialicon.dto.request.TokenRequest;
import com.socialicon.util.JwtUtil;
import com.socialicon.dto.request.LoginRequest;
import com.socialicon.dto.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));

        UserEntity user = userRepository.findByEmail(loginRequest.getEmail());
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setUserId(user.getId());
        tokenRequest.setEmail(user.getEmail());

        String token = jwtUtil.generateToken(tokenRequest);
        return new LoginResponse(token);
    }
}