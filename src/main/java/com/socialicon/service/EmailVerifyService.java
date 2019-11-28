package com.socialicon.service;

import com.socialicon.dto.request.EmailVerifyRequest;
import com.socialicon.dto.response.EmailVerifyResponse;

public interface EmailVerifyService {
    EmailVerifyResponse verifyEmail(EmailVerifyRequest emailVerifyRequest) throws Exception;
}
