package com.socialicon.service.sign;

import com.socialicon.dao.entity.AccountEntity;
import com.socialicon.dao.entity.ProfileEntity;
import com.socialicon.dao.repository.AccountRepository;
import com.socialicon.dao.repository.ProfileRepository;
import com.socialicon.dto.request.SignRequest;
import com.socialicon.dto.response.SignResponse;
import com.socialicon.util.classes.AuthUtil;
import com.socialicon.util.classes.DateUtil;
import com.socialicon.util.classes.EmailUtil;
import com.socialicon.util.classes.StringUtil;
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
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SignResponse sign(SignRequest signRequest) throws Exception {
        AccountEntity user = accountRepository.findByEmail(signRequest.getEmail());
        //Check the mail address has already been created.
        if(user != null){
            // TODO
            // Throw any exception
            throw new Exception("1000");
        }else{
            //Check email address validity
            if(authUtil.ValidateEmailAdress(signRequest.getEmail())){
                user = accountRepository.save(new AccountEntity(signRequest.getEmail(),
                        authUtil.CryptPassword(signRequest.getPassword()),
                        dateUtil.GetDateNow())
                );
                //If create account process successful
                if(user != null){
                    ProfileEntity profile = new ProfileEntity();
                    profile = profileRepository.save(new ProfileEntity(user.getId(),
                            signRequest.getFullname(),
                            stringUtil.CreateGuestName(signRequest.getFullname()))
                    );

                    //TODO
                    //String emailID = "firatipekk94@gmail.com";
                    //emailUtil.sendEmail(emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
                }else{
                    // TODO
                    // Throw any exception
                    throw new Exception("1002");
                }
            }else{
                // TODO
                // Throw any exception
                throw new Exception("1001");
            }
        }

        String token = "asd";
        return new SignResponse(token);
    }
}
