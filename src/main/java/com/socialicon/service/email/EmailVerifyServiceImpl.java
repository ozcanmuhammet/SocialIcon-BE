package com.socialicon.service.email;

import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.dao.repository.AccountRepository;
import com.socialicon.dto.request.EmailVerifyRequest;
import com.socialicon.dto.response.EmailVerifyResponse;
import com.socialicon.dto.response.SignResponse;
import com.socialicon.util.classes.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVerifyServiceImpl implements EmailVerifyService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public EmailVerifyResponse verifyEmail(EmailVerifyRequest emailVerifyRequest) throws Exception {
        AccountEntity user = accountRepository.findByEmail(emailVerifyRequest.getEmail());
        //Check the mail address has already been created.
        if(user != null){
            // TODO
            // Throw any exception
            throw new Exception("1000");
        }else{
            if(!authUtil.ValidateEmailAdress(emailVerifyRequest.getEmail())){
                // TODO
                // Throw any exception
                throw new Exception("1001");
            }
            return new EmailVerifyResponse(true);
        }
    }
}
