package com.socialicon.impl;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.common.exceptions.EmailAlreadyExistException;
import com.socialicon.common.exceptions.EmailNotValidException;
import com.socialicon.dao.entity.UserEntity;
import com.socialicon.dao.entity.ProfileEntity;
import com.socialicon.dao.repository.UserRepository;
import com.socialicon.dao.repository.ProfileRepository;
import com.socialicon.dto.request.SignRequest;
import com.socialicon.dto.response.SignResponse;
import com.socialicon.service.SignService;
import com.socialicon.common.utils.AuthUtil;
import com.socialicon.common.utils.DateUtil;
import com.socialicon.common.utils.EmailUtil;
import com.socialicon.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignServiceImpl implements SignService{

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private StringUtil stringUtil;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SignResponse sign(SignRequest signRequest) throws Exception {
        UserEntity user = userRepository.findByEmail(signRequest.getEmail());
        //Check the mail address has already been created.
        if(user != null){
            throw new EmailAlreadyExistException(ErrorCodes.EMAIL_ALREADY_EXIST.getErrorMessage() + signRequest.getEmail());
        } else{
            //Check email address validity
            if(authUtil.ValidateEmailAdress(signRequest.getEmail())){
                user = userRepository.save(new UserEntity(signRequest.getEmail(),
                        authUtil.CryptPassword(signRequest.getPassword()),
                        dateUtil.GetDateNow())
                );
                //If create account process successful
                if(user != null) {
                    ProfileEntity profile = new ProfileEntity();
                    profile = profileRepository.save(new ProfileEntity(user.getId(),
                            signRequest.getFullname(),
                            stringUtil.CreateGuestName(signRequest.getFullname()))
                    );

                    //TODO
                    //String emailID = "firatipekk94@gmail.com";
                    //emailUtil.sendEmail(emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
                } else{
                    // TODO
                    // Throw any exception
                    throw new Exception("1002");
                }
            } else{
                throw new EmailNotValidException(ErrorCodes.EMAIL_NOT_VALID.getErrorMessage() + signRequest.getEmail());
            }
        }

        String token = "asd";
        return new SignResponse(token);
    }
}
