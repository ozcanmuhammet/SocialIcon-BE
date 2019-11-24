package com.socialicon.util;

import com.socialicon.dto.request.TokenRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Generate token for user
    public String generateToken(TokenRequest request) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("USER_ID", request.getUserId());
        claims.put("EMAIL", request.getEmail());

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

    // Validate token
    public boolean validateToken(String token, UserDetails user) {
        final String email = getEmailFromToken(token);
        return email.equals(user.getUsername()) && !isTokenExpired(token);
    }

    // Retrieve email (username) from token
    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // Retrieve expiration date from token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Date calculateExpirationDate(Date createdDate) {
        int expirationInHours = 3;
        Instant expirationDate = createdDate.toInstant().plus(Duration.ofHours(expirationInHours));
        return Date.from(expirationDate);
    }

    // Check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // For retrieving any information from token, we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("thisisthesecretkey")
                .parseClaimsJws(token)
                .getBody();
    }
}
