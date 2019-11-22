package com.socialicon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignRequest {

    private String email;
    private String password;
    private String fullname;
}
