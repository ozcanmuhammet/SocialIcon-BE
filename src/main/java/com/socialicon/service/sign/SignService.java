package com.socialicon.service.sign;

import com.socialicon.dto.request.SignRequest;
import com.socialicon.dto.response.SignResponse;

public interface SignService {

    SignResponse sign(SignRequest signRequest) throws Exception;
}
