package com.socialicon.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TokenRequest {
    private Long userId;
    private String email;
}
