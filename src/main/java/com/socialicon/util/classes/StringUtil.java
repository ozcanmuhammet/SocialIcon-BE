package com.socialicon.util.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    @Autowired
    private DateUtil dateUtil;

    public String CreateGuestName(String fullname){
        return fullname.replaceAll("\\s","").concat(dateUtil.GetTimeStamp());
    }
}
