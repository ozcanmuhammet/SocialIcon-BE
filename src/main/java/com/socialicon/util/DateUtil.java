package com.socialicon.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {

    public String GetDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String GetTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return Long.toString(timestamp.getTime());
    }
}
