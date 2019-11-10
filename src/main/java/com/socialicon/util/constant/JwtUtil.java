package com.socialicon.util.constant;

import com.socialicon.web.request.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    public String generateToken(LoginRequest request) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("USER_ID", request.getEmail());

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(request.getEmail())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, "thisisthesecretkey")
                .compact();

    }

    private Date calculateExpirationDate(Date createdDate) {
        int expirationInHours = 3;
        Instant expirationDate = createdDate.toInstant().plus(Duration.ofHours(expirationInHours));
        return Date.from(expirationDate);
    }
}
