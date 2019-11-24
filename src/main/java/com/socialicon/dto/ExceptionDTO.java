package com.socialicon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDTO {
    private Date timestamp;
    private String errorCode;
    private String errorMessage;
}
