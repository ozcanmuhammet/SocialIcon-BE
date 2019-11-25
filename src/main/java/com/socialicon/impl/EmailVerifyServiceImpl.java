package com.socialicon.impl;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.common.exceptions.EmailAlreadyExistException;
import com.socialicon.common.exceptions.EmailNotValidException;
import com.socialicon.dao.entity.UserEntity;
import com.socialicon.dao.repository.UserRepository;
import com.socialicon.dto.request.EmailVerifyRequest;
import com.socialicon.dto.response.EmailVerifyResponse;
import com.socialicon.service.EmailVerifyService;
import com.socialicon.common.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVerifyServiceImpl implements EmailVerifyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public EmailVerifyResponse verifyEmail(EmailVerifyRequest emailVerifyRequest) {
        UserEntity user = userRepository.findByEmail(emailVerifyRequest.getEmail());
        //Check the mail address has already been created.
        if(user != null){
            throw new EmailAlreadyExistException(ErrorCodes.EMAIL_ALREADY_EXIST.getErrorMessage() + emailVerifyRequest.getEmail());
        }else{
            if(!authUtil.ValidateEmailAdress(emailVerifyRequest.getEmail())){
                throw new EmailNotValidException(ErrorCodes.EMAIL_NOT_VALID.getErrorMessage() + emailVerifyRequest.getEmail());
            }
            return new EmailVerifyResponse(true);
        }
    }
}
