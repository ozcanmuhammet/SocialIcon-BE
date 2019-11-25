package com.socialicon.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AuthUtil {

    public String CryptPassword(String password){
        String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return generatedSecuredPasswordHash;
    }

    public Boolean EncrytPassword(String password, String hashPassword){
        boolean matched = BCrypt.checkpw(password, hashPassword);
        return matched;
    }

    public Boolean ValidateEmailAdress(String emailAdress){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAdress);
        return  matcher.matches();
    }
}
