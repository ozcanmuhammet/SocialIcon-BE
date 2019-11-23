package com.socialicon.service.email;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.common.exceptions.EmailAlreadyExistException;
import com.socialicon.common.exceptions.EmailNotValidException;
import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.dao.repository.AccountRepository;
import com.socialicon.dto.request.EmailVerifyRequest;
import com.socialicon.dto.response.EmailVerifyResponse;
import com.socialicon.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVerifyServiceImpl implements EmailVerifyService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public EmailVerifyResponse verifyEmail(EmailVerifyRequest emailVerifyRequest) {
        AccountEntity user = accountRepository.findByEmail(emailVerifyRequest.getEmail());
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
