package com.socialicon.web.controller.exception;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.dto.ExceptionDTO;
import com.socialicon.common.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionDTO exception = new ExceptionDTO(new Date(), ErrorCodes.USER_NOT_FOUND.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
